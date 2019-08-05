package com.aaa.project.system.api;

import com.aaa.project.system.carwashperson.domain.Carwashperson;
import com.aaa.project.system.carwashperson.service.ICarwashpersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/api/login")
public class ApiLoginController {
    @Autowired
    private ICarwashpersonService carwashpersonServiceImpl;

    @RequestMapping("/user")
    @ResponseBody
    public Carwashperson login(String washpersonphone){
        Carwashperson login = carwashpersonServiceImpl.login(washpersonphone);
        return login;
    }
}
