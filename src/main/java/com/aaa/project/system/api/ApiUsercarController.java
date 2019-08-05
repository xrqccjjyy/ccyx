package com.aaa.project.system.api;

import com.aaa.project.system.usercar.domain.Usercar;
import com.aaa.project.system.usercar.service.UsercarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usercar")
public class ApiUsercarController {
    @Autowired
    private UsercarServiceImpl usercarService;
    @RequestMapping("/updateUsercars")
    public Boolean updateUsercars(@RequestBody Usercar usercar) {
        if (usercarService.updateUsercars(usercar)){
            return true;
        }
        return false;
    }
}
