package com.lostsearch.service;

import com.lostsearch.pojo.Userpojo;

import java.util.Date;

public interface UserService {
    Userpojo usercheck(String username, String password);
    void register(String studentid, String password, String username);
    Object studentidcheck(String username);
}
