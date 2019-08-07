package com.aaa.project.system.api;

import com.aaa.project.system.code.domain.Code;
import com.aaa.project.system.code.service.CodeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/code")
public class ApiCodeController {
    @Autowired
    private CodeServiceImpl codeService;
    @RequestMapping("/addUserVerify")
    public void addUserVerify(String userphone){
        int codenums=(int)((Math.random()*9+1)*1000);
        Code code = new Code();
        code.setUserphone(userphone);
        code.setCodenum(codenums);
        codeService.addUserVerify(userphone,codenums);
        System.out.println(userphone+","+codenums);
    }
}
