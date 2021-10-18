package com.lostsearch.controller;

import com.lostsearch.common.Result;
import com.lostsearch.pojo.Userpojo;
import com.lostsearch.service.UserServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.logging.log4j.util.Strings.isEmpty;


@RestController
public class RegisterControler {
    @Autowired
    private UserServiceimpl userServe;
    @PostMapping("/user/register")
    public Result register(@RequestBody Userpojo user){
        if(!isEmpty(user.getStudentid())&&!isEmpty(user.getPassword())&&!isEmpty(user.getName())){
            if(userServe.studentidcheck(user.getStudentid())==null){
                userServe.register(user.getStudentid(),user.getPassword(),user.getName());
                return Result.success("注册成功！");
            }else{
                return Result.fail("-2","学生ID已存在！");
            }
        }else{
            return Result.fail("-1","学生ID或密码或用户名不能为空");
        }
    }
}
