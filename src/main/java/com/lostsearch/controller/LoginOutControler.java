package com.lostsearch.controller;

import com.lostsearch.common.Result;
import com.lostsearch.configure.TokenService;
import com.lostsearch.service.UserServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginOutControler {
    @Autowired
    private UserServiceimpl userServe;
    private TokenService token;
    @GetMapping("/user/loginout")
    public Result loginout(HttpServletRequest req){
        String token=req.getHeader("token");
        token=null;
        return Result.success("退出成功！");
    }
}
