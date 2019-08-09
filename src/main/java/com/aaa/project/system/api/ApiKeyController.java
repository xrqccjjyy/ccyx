package com.aaa.project.system.api;

import com.aaa.project.system.orders.domain.Orders;
import com.aaa.project.system.orders.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/key")
public class ApiKeyController {


    @Autowired
    private IOrdersService ordersServiceImpl;



    /**
     * 洗车人员存放钥匙
     */
    @RequestMapping("/updateKey")
    public int  updateKey(Orders orders){
        int i=ordersServiceImpl.updateKey( orders );
        return i;
    }
}
