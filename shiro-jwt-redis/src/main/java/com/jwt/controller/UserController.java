package com.jwt.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jwt.entity.User;
import com.jwt.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public User getUser() {
        // User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUserName, "admin"));
        // User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUserName, "admin"));
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>()
                .select(User::getId, User::getRealName)
                .eq(User::getUserName, "admin");
        User user = userService.getOne(queryWrapper);
        log.info("dd" + user.getRealName());
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public User getUserCon() {
        /*LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>()
                .eq(User::getId, 2)
                .ne(User::getUserName, "admin");*/
        // queryWrapper.last("limit 1");
        // User user = userService.getOne(queryWrapper);

        User user = userService.getUserByName("admin");
//          User user = sysService.getUserByName("admin");
        User user1 = userService.getUser();
//         User user1 = sysService.getUser();
        log.info("ddddd " + user.toString());
        return user;
    }

    /*@ResponseBody
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Integer insetUser() {
        log.info("insert into user");
        return userService.inserUser("guest");
    }*/
}
