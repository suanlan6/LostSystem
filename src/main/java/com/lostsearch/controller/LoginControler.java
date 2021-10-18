package com.lostsearch.controller;

import com.lostsearch.common.Result;
import com.lostsearch.configure.TokenService;
import com.lostsearch.pojo.Userpojo;
import com.lostsearch.service.UserServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.logging.log4j.util.Strings.isEmpty;

@RestController
public class LoginControler {
    @Autowired
    private UserServiceimpl userServe;
    private TokenService token;
    @PostMapping("/user/login")
    public Result login(@RequestBody Userpojo user){
        if(!isEmpty(user.getStudentid())&&!isEmpty(user.getPassword())){
            if(userServe.usercheck(user.getStudentid(),user.getPassword())!=null){
                token.getToken(user);
                return Result.success("1","登录成功",token);
            }else{
                return Result.fail("-1","用户名或者密码错误！");
            }
        }else{
            return Result.fail("-1","用户名或者密码不能为空！");
        }
    }
}
