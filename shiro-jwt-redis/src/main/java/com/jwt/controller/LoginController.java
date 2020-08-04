package com.jwt.controller;

import com.alibaba.fastjson.JSONObject;
import com.jwt.constant.CommonConstant;
import com.jwt.entity.User;
import com.jwt.service.UserService;
import com.jwt.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/sys")
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<JSONObject> login(@Validated @RequestBody User loginUser) {
        String username = loginUser.getUserName();
        String password = loginUser.getPassWord();

        Result<JSONObject> result = new Result<>();

        // 1、校验用户是否有效
        User user = userService.getUserByName(username);
        result = userService.checkUserIsEffective(user);
        if (!result.isSuccess()) {
            return result;
        }

        // 2、检验用户名或密码是否正确
        String userpassword = PasswordUtil.encrypt(username, password, user.getSalt());
        String syspassword = user.getPassWord();
        if (!syspassword.equals(userpassword)) {
            result.error500("用户名或密码错误");
            return result;
        }

        // 用户登陆信息
        userInfo(user, result);
        return result;
    }

    /**
     * 退出登陆
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Result<Object> logout(HttpServletRequest request, HttpServletResponse response) {
        // 用户退出逻辑
        String token = request.getHeader(CommonConstant.ACCESS_TOKEN);
        if (CommonUtils.isEmpty(token)) {
            return Result.error("退出登录失败！");
        }
        String username = JwtUtil.getUsername(token);
        User sysUser = userService.getUserByName(username);
        if (sysUser != null) {
            log.info(" 用户名：" + username + " ,退出登陆！");
            // 清空用户token缓存
            redisUtil.del(CommonConstant.PREFIX_USER_TOKEN + token);
            //清空用户权限缓存：权限Perms和角色集合
            redisUtil.del(CommonConstant.LOGIN_USER_CACHERULES_ROLE + username);
            redisUtil.del(CommonConstant.LOGIN_USER_CACHERULES_PERMISSION + username);
            return Result.ok("退出登录成功！");
        } else {
            return Result.error("无效的token");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
    public Result authorized(HttpServletRequest request, HttpServletResponse response) {
        log.info("权限不够！");
        return Result.error("权限不够！");
    }


    private Result<JSONObject> userInfo(User user, Result<JSONObject> result) {
        String syspassword = user.getPassWord();
        String sysusername = user.getUserName();
        // 生成token
        String token = JwtUtil.sign(sysusername, syspassword);
        redisUtil.set(CommonConstant.PREFIX_USER_TOKEN + token, token);
        // 设置超时时间
        redisUtil.expire(CommonConstant.PREFIX_USER_TOKEN + token, JwtUtil.EXPIRE_TIME / 1000);

        // 获取用户部门信息
        JSONObject obj = new JSONObject();
        obj.put("token", token);
        obj.put("userInfo", user);
        result.setResult(obj);
        result.success("登录成功");
        return result;
    }
}
