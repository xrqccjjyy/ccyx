package com.aaa.project.system.orders.controller;

import java.util.List;

import com.aaa.project.system.carwashperson.domain.Carwashperson;
import com.aaa.project.system.carwashperson.service.ICarwashpersonService;
import org.apache.avro.Schema;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * 订单 信息操作处理
 * 
 * @author teacherChen
 * @date 2019-07-29
 */
@Controller
@RequestMapping("/system/orders")
public class OrdersController extends BaseController
{
    private String prefix = "system/orders";
	
	@Autowired
	private IOrdersService ordersService;

	@Autowired
	private ICarwashpersonService carwashpersonService;
	
	@RequiresPermissions("system:orders:view")
	@GetMapping()
	public String orders()
	{
	    return prefix + "/orders";
	}
	
	/**
	 * 查询订单列表
	 */
	@RequiresPermissions("system:orders:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Orders orders)
	{
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
    public AjaxResult export(Orders orders)
    {
    	List<Orders> list = ordersService.selectOrdersList(orders);
        ExcelUtil<Orders> util = new ExcelUtil<Orders>(Orders.class);
        return util.exportExcel(list, "orders");
    }
	
	/**
	 * 新增订单
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存订单
	 */
	@RequiresPermissions("system:orders:add")
	@Log(title = "订单", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Orders orders)
	{		
		return toAjax(ordersService.insertOrders(orders));
	}

	/**
	 * 修改订单
	 */
	@GetMapping("/edit/{orderid}")
	public String edit(@PathVariable("orderid") Integer orderid, ModelMap mmap, Model model,Carwashperson carwashperson)
	{
		Orders orders = ordersService.selectOrdersById(orderid);
		List<Carwashperson>  list =carwashpersonService.selectCarwashpersonStatus();
		model.addAttribute("carwashpersonList", list);
		mmap.put("orders", orders);
		carwashperson.setWashpersonstatus("忙碌中");
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存订单
	 */
	@RequiresPermissions("system:orders:edit")
	@Log(title = "订单", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Orders orders,Carwashperson carwashperson)
	{
		carwashpersonService.updateCarwashpersonStatus(carwashperson);
		return toAjax(ordersService.updateOrders(orders));
	}
	
	/**
	 * 删除订单
	 */
	@RequiresPermissions("system:orders:remove")
	@Log(title = "订单", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(ordersService.deleteOrdersByIds(ids));
	}


	/**
	 * 订单详情
	 * */
	@RequiresPermissions("system:orders:detail")
	@GetMapping("/detail/{orderid}")
	public String detail(@PathVariable("orderid") Integer orderid, ModelMap mmap)
	{
		mmap.put("orderList", ordersService.selectOrdersById(orderid));
		return prefix + "/detail";
	}

	/**
	 * 指派洗车人员
	 */
	@GetMapping("/assigned/{orderid}")
	public String assigned(@PathVariable("orderid") Integer orderid, ModelMap mmap, Model model)
	{
		Orders orders = ordersService.selectOrdersById(orderid);
		List<Carwashperson>  list =carwashpersonService.selectCarwashpersonList(null);
		model.addAttribute("carwashpersonList", list);
		System.out.println(list.size()+"=====================================================");
		mmap.put("orders", orders);
		return prefix + "/assigned";
	}

	/**
	 * 保存指派人员
	 */
	@RequiresPermissions("system:orders:assigned")
	@Log(title = "订单", businessType = BusinessType.UPDATE)
	@PostMapping("/assigned")
	@ResponseBody
	public AjaxResult assignedSave(Orders orders)
	{
		return toAjax(ordersService.updateOrders(orders));
	}

	
}
