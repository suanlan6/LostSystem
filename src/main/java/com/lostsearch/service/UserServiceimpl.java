package com.lostsearch.service;

import com.lostsearch.mapper.UserMapper;
import com.lostsearch.pojo.Userpojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceimpl implements UserService{
    @Autowired
    private UserMapper usermapper;

    @Override
    public Userpojo usercheck(String username, String password) {
        return usermapper.getbynameandpassword(username,password);
    }

    @Override
    public void register(String studentid, String password, String username) {
        usermapper.insertusers(studentid,password,username);
    }

    @Override
    public Object studentidcheck(String studentid) {
        return usermapper.getbystudentid(studentid);
    }
}
