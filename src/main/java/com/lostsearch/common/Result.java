package com.lostsearch.common;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private String code;
    private String message;
    private Object data;
    public static Result success(String s, String success, Object data){
        Result r=new Result();
        r.code=CommonEnum.SUCCESS.getcode();
        r.message=CommonEnum.SUCCESS.getmsg();
        r.data=data;
        return r;
    }
    public static Result success(String msg){
        Result r=new Result();
        r.setCode("1");
        r.setMessage(msg);
        r.setData(null);
        return r;
    }
    public static Result success(){
        return success(null);
    }
    public static Result fail(BaseErros bserro){
        Result r=new Result();
        r.setCode(bserro.getcode());
        r.setMessage(bserro.getmsg());
        r.setData(null);
        return r;
    }
    public static Result fail(String code,String msg){
        Result r=new Result();
        r.setCode(code);
        r.setMessage(msg);
        r.setData(null);
        return r;
    }
    public static Result fail(String msg){
        Result r=new Result();
        r.setCode("-1");
        r.setMessage(msg);
        r.setData(null);
        return r;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
