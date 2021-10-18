package com.lostsearch.configure;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.lostsearch.common.BizException;
import com.lostsearch.pojo.Userpojo;
import com.lostsearch.service.UserServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Autowired
    private UserServiceimpl userService;
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        String token=req.getHeader("token");
        if(token==null){
            throw new BizException("401","没有权限！");
        }else{
            String studentid = null;
            try{
                studentid= JWT.decode(token).getAudience().get(0);
            }catch (JWTDecodeException e){
                e.printStackTrace();
            }
            Userpojo user=(Userpojo) userService.studentidcheck(studentid);
            if(user==null){
                throw new BizException("不存在用户！");
            }
            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(user.getPassword())).build();
            try{
                jwtVerifier.verify(token);
            }catch (JWTVerificationException e){
                e.printStackTrace();
            }
            return true;
        }
    }
}
