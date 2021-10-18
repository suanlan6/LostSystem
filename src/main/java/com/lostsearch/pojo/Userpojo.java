package com.lostsearch.pojo;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Userpojo {
    @NotBlank(message = "学号不能为空")
    private String studentid;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "用户名不能为空")
    private String name;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
