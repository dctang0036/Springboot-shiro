package com.jwt.controller;

import com.jwt.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class SysUserController {

    @RequiresPermissions("user:list")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result userList() {
        return Result.ok("获取用户信息");
    }

    @RequiresPermissions("user:addd")
    @RequestMapping("add")
    public Result userAdd() {
        return Result.ok("新增用户");
    }

    @RequiresPermissions("user:delete")
    @RequestMapping("delete")
    public Result userDelete() {
        return Result.ok("删除用户");
    }

    @RequiresPermissions("user:update")
    @RequestMapping("update")
    public Result userUpdate() {
        return Result.ok("修改用户");
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Result test() {
        return Result.ok("不用登陆直接访问的接口");
    }

}
