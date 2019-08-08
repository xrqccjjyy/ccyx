package com.aaa.project.system.api;

import com.aaa.project.system.customer.service.ICustomerService;
import com.aaa.project.system.ordernumberserviceid.service.IOrdernumberserviceidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/CustomerCar")
public class ApiCustomerCarController {

    @Autowired
    private ICustomerService customerService;

    /**
     * 获取顾客信息和对应的车辆(默认)
     * @return
     */
    @RequestMapping("/selectCustomerCar")
     public List<Map<String,Object>> selectCustomerCar(String userphone){
        List<Map<String,Object>>  mapList = customerService.slectCustomerCar(userphone);
        return mapList;
     }


}
