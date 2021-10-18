package com.lostsearch.mapper;

import com.lostsearch.pojo.Userpojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Mapper
@Repository
public interface UserMapper {
    //Mapper层查找方法
    Userpojo getbynameandpassword(String username, String password);
    //Mapper层插入方法
    Integer insertusers(String studentid, String password,String username);
    //Mapper层查找方法
    Object getbystudentid(String studentid);
}
