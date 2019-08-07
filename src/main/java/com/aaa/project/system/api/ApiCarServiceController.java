package com.aaa.project.system.api;

import com.aaa.project.system.carservice.service.ICarserviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/carService")
public class ApiCarServiceController {

    @Autowired
    private ICarserviceService carserviceService;

    /**
     * 查询所有汽车服务
     * @return
     */
    @RequestMapping("/selectAllCarService")
    public List<Map<String,Object>> selectAllCarService(){
        List<Map<String,Object>> mapList = carserviceService.selectAllCarService();
        return mapList;

    }
}
