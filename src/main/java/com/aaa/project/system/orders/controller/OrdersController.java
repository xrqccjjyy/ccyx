package com.aaa.project.system.orders.controller;

import java.util.List;

import com.aaa.framework.config.DouDouConfig;
import com.aaa.project.system.carwashperson.domain.Carwashperson;
import com.aaa.project.system.carwashperson.service.ICarwashpersonService;
import com.aaa.project.system.debty.domain.Debty;
import com.aaa.project.system.debty.service.IDebtyService;
import com.aaa.project.system.orderhistory.domain.Orderhistory;
import com.aaa.project.system.orderhistory.service.IOrderhistoryService;
import com.aaa.project.system.user.domain.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.avro.Schema;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.aaa.framework.aspectj.lang.annotation.Log;
import com.aaa.framework.aspectj.lang.enums.BusinessType;
import com.aaa.project.system.orders.domain.Orders;
import com.aaa.project.system.orders.service.IOrdersService;
import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.page.TableDataInfo;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.common.utils.poi.ExcelUtil;

import javax.ws.rs.Path;

/**
 * 订单 信息操作处理
 *
 * @author teacherChen
 * @date 2019-07-29
 */
@Controller
@RequestMapping("/system/orders")
public class OrdersController extends BaseController {
    private String prefix = "system/orders";

    @Autowired
    private IOrdersService ordersService;

    @Autowired
    private ICarwashpersonService carwashpersonService;

    @Autowired
    private IOrderhistoryService orderhistoryService;

    @Autowired
    private IDebtyService debtyService;

    @RequiresPermissions("system:orders:view")
    @GetMapping()
    public String orders() {
        return prefix + "/orders";
    }

    /**
     * 查询订单列表
     */
    @RequiresPermissions("system:orders:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Orders orders) {
        startPage();
        List<Orders> list = ordersService.selectOrdersList(orders);
        return getDataTable(list);
    }


    /**
     * 导出订单列表
     */
    @RequiresPermissions("system:orders:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Orders orders) {
        List<Orders> list = ordersService.selectOrdersList(orders);
        ExcelUtil<Orders> util = new ExcelUtil<Orders>(Orders.class);
        return util.exportExcel(list, "orders");
    }

    /**
     * 新增订单
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存订单
     */
    @RequiresPermissions("system:orders:add")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Orders orders) {
        return toAjax(ordersService.insertOrders(orders));
    }

    /**
     * 分派洗车人员，并修改订单状态为进行中
     */
    @GetMapping("/edit/{orderid}")
    public String edit(@PathVariable("orderid") Integer orderid, ModelMap mmap, Model model, Carwashperson carwashperson) {

        Orders orders = ordersService.selectOrdersById(orderid);
        //查询洗车人状态
        List<Carwashperson> list = carwashpersonService.selectCarwashpersonStatus();
        ordersService.updateOrdersGoing(orderid);
        model.addAttribute("carwashpersonList", list);

        mmap.put("orders", orders);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单
     */
    @RequiresPermissions("system:orders:edit")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave( Orders orders, Carwashperson carwashperson) {

        /*
        * 将操作加入到历史记录表中
        * */
        Integer ordersid =  orders.getOrderid();
        Orders ordera  = ordersService.selectOrdersById(ordersid);
        String ordernumber =  ordera.getOrdernumber();
        String orderstatus = "指派了洗车人员";
        orderhistoryService.insertOrderhistoryTable(ordernumber, orderstatus);

        //更新洗车人员状态
        carwashpersonService.updateCarwashpersonStatus(carwashperson);
        return toAjax(ordersService.updateOrders(orders));
    }

    /**
     * 删除订单
     */
    @RequiresPermissions("system:orders:remove")
    @Log(title = "订单", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(ordersService.deleteOrdersByIds(ids));
    }


    /**
     * 订单详情
     */
    @RequiresPermissions("system:orders:detail")
    @GetMapping("/detail/{orderid}")
    public String detail(@PathVariable("orderid") Integer orderid, ModelMap mmap) {
        /*
         * 将操作加入到历史记录表中
         * */
        Orders orders  = ordersService.selectOrdersById(orderid);
        String ordernumber =  orders.getOrdernumber();
        String orderstatus = "查看了订单详情";
        orderhistoryService.insertOrderhistoryTable(ordernumber, orderstatus);

        mmap.put("orderList", ordersService.selectOrdersById(orderid));
        return prefix + "/detail";
    }


    /**
     * 接收订单
     */
   /* @GetMapping("/receive/{orderid}")
    public String receive(@PathVariable("orderid") Integer orderid, Orders orders, ModelMap mmap, Model model) {
        mmap.put("ordersa", ordersa);
        return prefix + "/receive";
    }*/

    /**
     * 保存接收的订单
     */
    @RequiresPermissions("system:orders:receive")
    @Log(title = "保存接收订单", businessType = BusinessType.UPDATE)
    @PostMapping("/receive/{orderid}")
    @ResponseBody
    public AjaxResult receiveSave(@PathVariable("orderid") Integer orderid,Model model) {
        /*
         * 将操作加入到历史记录表中
         * */
        Orders orders  = ordersService.selectOrdersById(orderid);
        System.out.println(orders.getOrderstatus()+"==================================================");
        model.addAttribute("a",orders.getOrderstatus());
        String ordernumber =  orders.getOrdernumber();
        String orderstatus = "接收了订单";
        orderhistoryService.insertOrderhistoryTable(ordernumber, orderstatus);

        return toAjax(ordersService.updateOrdersStatus(orderid));
    }




    /**
     * 拒收订单
     */
    /*@GetMapping("/reject/{orderid}")
    public String reject(@PathVariable("orderid") Integer orderid, Orders orders, ModelMap mmap,Model model) {
        Orders ordersr = ordersService.selectOrdersById(orderid);
        mmap.put("ordersr", ordersr);
        return prefix + "/reject";
    }*/

    /**
     * 保存拒收的订单
     * */
    @RequiresPermissions("system:orders:reject")
    @Log(title = "保存拒收的订单", businessType = BusinessType.UPDATE)
    @PostMapping("/reject/{orderid}")
    @ResponseBody
    public AjaxResult rejectSave(@PathVariable("orderid") Integer orderid) {
        /*
         * 将操作加入到历史记录表中
         * */
        Orders orders  = ordersService.selectOrdersById(orderid);
        String ordernumber =  orders.getOrdernumber();
        String orderstatus = "拒收了订单";
        orderhistoryService.insertOrderhistoryTable(ordernumber, orderstatus);

        return toAjax(ordersService.updateOrdersStatusReject(orderid));
    }


    /**
     * 确认签收订单
     * */
/*    @GetMapping("/confirm/{orderid}")
    public String confirm(@PathVariable("orderid") Integer orderid, Orders orders, ModelMap mmap){
        Orders ordersc =  ordersService.selectOrdersById(orderid);
        mmap.put("ordersc", ordersc);
        return prefix + "/confirm";
    }*/

    /**
     * 保存签收的订单
     */
    @RequiresPermissions("system:orders:confirm")
    @Log(title = "保存签收的订单", businessType = BusinessType.UPDATE)
    @PostMapping("/confirm/{orderid}")
    @ResponseBody
    public AjaxResult confirmSave(@PathVariable("orderid") Integer orderid, Debty debty) {
        /*
         * 将操作加入到历史记录表中
         * */
        Orders orders  = ordersService.selectOrdersById(orderid);
        String ordernumber =  orders.getOrdernumber();
        String orderstatus = "签收了订单";
        orderhistoryService.insertOrderhistoryTable(ordernumber, orderstatus);

        //完成订单，修改订单财务表金额
        debtyService.updateDebtyMoney(debty);
        return toAjax(ordersService.updateOrdersStatusComfirm(orderid));
    }
}
