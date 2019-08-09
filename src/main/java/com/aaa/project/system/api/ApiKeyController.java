package com.aaa.project.system.api;

import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.project.system.keycabinets.service.IKeycabinetsService;
import com.aaa.project.system.orders.domain.Orders;
import com.aaa.project.system.orders.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/key")
public class ApiKeyController {

    @Autowired
    private IKeycabinetsService keycabinetsServiceImpl;
    @Autowired
    private IOrdersService ordersServiceImpl;

    @RequestMapping("/aroundContainer")
    public AjaxResult aroundContainer(@RequestParam(name = "posLng", required = true) String posLng,
                                      @RequestParam(name = "posLat", required = true) String posLat) {
        //1-新建结果对象
        AjaxResult ajaxResult = new AjaxResult();
        //2-根据经纬度得到周围钥匙柜
        List<Map<String, Object>> aroundContainerList = keycabinetsServiceImpl.getAroundContainer(posLng, posLat);
        //3-赋值
        ajaxResult.put("code",0);
        ajaxResult.put("aroundContainerList", aroundContainerList);
        //4-返回结果
        return ajaxResult;
    }

    /**
     * 洗车人员存放钥匙
     */
    @RequestMapping("/updateKey")
    public int  updateKey(Orders orders){
        int i=ordersServiceImpl.updateKey( orders );
        return i;
    }
}
