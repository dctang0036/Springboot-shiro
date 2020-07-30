package com.shiro.jwt.controller;

import com.shiro.jwt.domain.ApiMessage;
import com.shiro.jwt.domain.UserInfo;
import com.shiro.jwt.shiro.JWTFilter;
import com.shiro.jwt.utils.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class ShiroTestController {

    @PostMapping("/login")
    public ApiMessage<String> login() {
        Map<String, Object> map = new HashMap<>();
        map.put("userName", "jiaojiao");
        String token = JwtUtils.createToken((String)map.get("userName"));
        return new ApiMessage<>(true, "200", "", token);
    }

    @RequestMapping(value = "test", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @RequiresPermissions("add")
    public ApiMessage<String> test() {
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        System.out.println(userInfo.getUserName());
        return new ApiMessage<>(true, "200", "", "有权限访问！");
    }

}
