package com.aaa.project.system.api;

import com.aaa.framework.web.controller.BaseController;
import com.aaa.framework.web.domain.AjaxResult;
import com.aaa.project.system.customer.domain.Customer;
import com.aaa.project.system.usercar.domain.Usercar;
import com.aaa.project.system.usercar.service.UsercarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usercar")
public class ApiUsercarController extends BaseController {
    @Autowired
    private UsercarServiceImpl usercarService;
    @RequestMapping("/updateUsercars")
    public Boolean updateUsercars(@RequestBody Usercar usercar) {
        if (usercarService.updateUsercars(usercar)){
            return true;
        }
        return false;
    }

    @RequestMapping("/addUsercar")
    public int addUsercar(@RequestBody Usercar usercar) {
        int i = usercarService.insertUsercar(usercar);
        return i;
    }

    @RequestMapping("/selectUsercarByUserId")
    public List<Usercar> selectUsercarByUserId(Integer userid){
        List<Usercar> usercarList = usercarService.selectUsercarByUserId(userid);
        return usercarList;
    }

    @RequestMapping("/selectUsercarById")
    public Usercar selectUsercarById(Integer usercarid){
        Usercar usercar = usercarService.selectUsercarById(usercarid);
        return usercar;
    }
}
