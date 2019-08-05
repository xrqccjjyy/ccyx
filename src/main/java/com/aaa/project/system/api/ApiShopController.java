package com.aaa.project.system.api;

import com.aaa.project.system.shop.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/shop")
public class ApiShopController {

    @Autowired
    private IShopService shopService;

    /**
     * 获取所有商家
     */
    @RequestMapping("/selectAllShop")
    public List<Map<String,Object>> selectAllShop(){
        List<Map<String,Object>> mapList = shopService.selectAllShop();
        System.out.println(mapList);
        System.out.println("调用商家表成功");
        return mapList;
    }

    /**
     * 模糊搜索
     */
    @RequestMapping("/toSearch")
    public List<Map<String,Object>> toSearch(String shopname){
        System.out.println(shopname);
        System.out.println("调用成功");
//        System.out.println(shopname+shopaddress);
        List<Map<String,Object>> mapList = shopService.selectSearch(shopname);
        System.out.println(mapList);

        System.out.println("调用搜索成功");
        return mapList;
    }
}
