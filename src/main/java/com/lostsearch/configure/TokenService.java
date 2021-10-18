package com.lostsearch.configure;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.lostsearch.pojo.Userpojo;
import org.springframework.stereotype.Service;

@Service("TokenService")
public class TokenService {
    public String getToken(Userpojo user){
        String token="";
        token= JWT.create().withAudience(user.getStudentid())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
