package com.aaa.project.system.api;

import com.aaa.project.system.orders.domain.Orders;
import com.aaa.project.system.orders.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/order")
public class ApiOrderController {

    @Autowired
    private IOrdersService ordersServiceImpl;


    /**
     * 订单列表
     * @param washpersonname
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Orders> findAll(String washpersonname){
        List<Orders> list = ordersServiceImpl.findAll(washpersonname);
        return list;
    }

    /**
     * 查看订单详情
     */
    @RequestMapping("/selectWxByid")
    @ResponseBody
    public List<Orders> selectWxByid(String ordernumber){
        List<Orders> orders = (List<Orders>) ordersServiceImpl.selectWxByid(ordernumber);
        System.out.println(orders);
        return orders;
    }
}
