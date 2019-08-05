package com.aaa.project.system.api;

import com.aaa.project.system.orders.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 顾客订单
 */
@RestController
@RequestMapping("/api/userOrder")
public class ApiUserOrderController {

    @Autowired
    private IOrdersService ordersService;

    /**
     * 微信端顾客获取全部订单
     */
    @RequestMapping("/selectAllOrder")
    public List<Map<String,Object>> selectByPhone(String userphone){
        System.out.println("获取手机号："+userphone);
        List<Map<String,Object>> ordersList =  ordersService.selectAllOrderByPhone(userphone);
        System.out.println(ordersList);
        System.out.println("获全部订单成功。。。。。。。");
        return ordersList;
    }



    //    待接单
    @RequestMapping("/selectAllWaitingOrder")
    public List<Map<String,Object>> selectAllWaitingOrder(String userphone){
        List<Map<String,Object>> ordersList =  ordersService.selectAllWaitingOrder(userphone);
        System.out.println(ordersList);
        System.out.println("获取待接单成功。。。。。。。");
        return ordersList;
    }

    /**
     * 进行中的订单
     */
    @RequestMapping("/ingOrder")
    public List<Map<String,Object>> ingOrder(String userphone){
        List<Map<String,Object>> ordersList =  ordersService.ingOrder("13249517780");
        System.out.println(ordersList);
        System.out.println("获进行中订单成功。。。。。。。");
        return ordersList;
    }

    /**
     * 已完成订单
     */
    @RequestMapping("/finishOrder")
    public List<Map<String,Object>> finishOrder(String userphone){
        List<Map<String,Object>> ordersList =  ordersService.finishOrder(userphone);
        System.out.println(ordersList);
        System.out.println("获进行中订单成功。。。。。。。");
        return ordersList;
    }

    /**
     * 已取消订单
     */
    @RequestMapping("/cancelledOrder")
    public List<Map<String,Object>> cancelledOrder(String userphone){
        List<Map<String,Object>> ordersList =  ordersService.cancelledOrder(userphone);
        System.out.println(ordersList);
        System.out.println("获进行中订单成功。。。。。。。");
        return ordersList;
    }

    //    取消订单
    @RequestMapping("/cancellBtnOrder")
    public Integer updateByOrdernumber(String ordernumber){
        int i = ordersService.updateByOrdernumber(ordernumber);
        System.out.println(i);
        System.out.println("取消订单成功。。。。。。。");
        return i;
    }

    //根据订单编号查询
    @RequestMapping("/selectByOrderNumber")
    public List<Map<String,Object>> selectByOrderNumber(String ordernumber){
        List<Map<String,Object>> mapList = ordersService.selectByOrderNumber(ordernumber);
        System.out.println(mapList);
        System.out.println("根据订单编号查询成功。。。。。。。");
        return mapList;
    }

}
