package com.aaa.project.system.api;

import com.aaa.project.system.orders.domain.Orders;
import com.aaa.project.system.orders.service.IOrdersService;
import io.swagger.models.auth.In;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
        System.out.println("获取已取消的订单成功。。。。。。。");
        return ordersList;
    }

    //  取消订单
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

    /**
     * 下单
     * 新增订单
     */
    @RequestMapping("/insertOrders")
    public Integer insertOrders(@RequestParam(name = "washtime", required = true) String washtime,
                                @RequestParam(name = "usercarid", required = true) Integer usercarid,
                                @RequestParam(name = "shopid", required = true) Integer shopid,
                                @RequestParam(name = "userid", required = true) Integer userid,
                                @RequestParam(name = "orderprice", required = true) long orderprice,
                                @RequestParam(name = "carserviceidList", required = true) String carserviceidList){

        System.out.println("送洗时间 "+washtime+" ,车辆id："+usercarid+",商家id："+shopid+",顾客id"+userid);

        //订单服务
//        String[] serviceList = serviceIdList.substring(1, serviceIdList.length() - 1).split(",");
//        List<String> list = Arrays.asList(serviceList);
//        orderServiceService.insertOrder(orderId, list);

        List<String> list = Arrays.asList(carserviceidList);
        System.out.println(carserviceidList);

        //自动生成订单编号
        String ordernumber=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        //将String类型转换成date格式
        java.sql.Date date = java.sql.Date.valueOf(washtime);
        System.out.println(date);

        Orders orders =  new Orders();
       // 下单时间
        orders.setOrdertime(new Date());
        //订单编号
        orders.setOrdernumber(ordernumber);
        //预约洗车时间
        orders.setWashtime(date);
        //车辆id
        orders.setUsercarid(usercarid);
        //商家
        orders.setShopid(shopid);
        //顾客id
        orders.setUserid(userid);
        //总金额
        orders.setOrderprice(orderprice);
        int i = ordersService.insertOrders(orders);
        System.out.println(ordernumber);
        System.out.println("新增订单成功。。"+i);
        return i;

    }

}
