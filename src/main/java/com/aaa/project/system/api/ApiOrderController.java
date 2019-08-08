package com.aaa.project.system.api;

import com.aaa.project.system.orders.domain.Orders;
import com.aaa.project.system.orders.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/api/order")
public class ApiOrderController {

    @Autowired
    private IOrdersService ordersServiceImpl;


    /**
     * 洗车人员取到车辆
     */
    @RequestMapping("/updateCar")
    @ResponseBody
    public int  updateCar(String ordernumber){
        int i = ordersServiceImpl.updateCar(ordernumber);
        return i;
    }

    /**
     * 洗车人员历史订单
     */
    @RequestMapping("/history")
    @ResponseBody
    public List<Orders> history(Orders orders){
        List<Orders> list = ordersServiceImpl.history( orders );
        return list;
    }


    /**
     * 洗车人员归还车辆
     */
    @RequestMapping("/updateWx")
    @ResponseBody
    public int  updateWx(String washpersonname){
        System.out.println(washpersonname);
        int i = ordersServiceImpl.updateWx(washpersonname);
        return i;
    }

    /**
     * 订单列表
     * @param washpersonname
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Orders> findAll(String washpersonname){
        System.out.println(washpersonname);
        List<Orders> list = ordersServiceImpl.findAll(washpersonname);
        System.out.println(list);
        return list;
    }

    /**
     * 查看订单详情
     */
    @RequestMapping("/selectWxByid")
    @ResponseBody
    public List<Orders> selectWxByid(String ordernumber){
        List<Orders> orders = ordersServiceImpl.selectWxByid(ordernumber);

        return orders;
    }






}
