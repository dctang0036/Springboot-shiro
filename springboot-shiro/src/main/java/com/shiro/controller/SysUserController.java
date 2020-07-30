package com.shiro.controller;


import com.shiro.domain.LoginResult;
import com.shiro.entity.SysUser;
import com.shiro.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author dctang
 * @since 2020-07-22
 */
@Controller
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private LoginService loginService;

    /**
     * 身份认证测试接口
     * @param request
     * @return
     */
    @RequestMapping("/admin")
    public String admin(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("userName");
        return "success";
    }

    /**
     * 角色认证测试接口
     * @param request
     * @return
     */
    @RequestMapping("/student")
    public String student(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("userName");
        return "success";
    }

    /**
     * 权限认证测试接口
     * @param request
     * @return
     */
    @RequestMapping("/teacher")
    public String teacher(HttpServletRequest request) {
        System.out.println("teacher test!");
        return "success";
    }

    /**
     * 用户登录接口
     * @param user
     * @param request
     * @return
     */
    // @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(SysUser user, HttpServletRequest request) {
        String userName = user.getUserName();
        String password = user.getPassWord();
        LoginResult loginResult = loginService.login(userName, password);

        if (loginResult.isLogin()) {
            return "success";
        } else {
            // System.out.println("login1");
            return "login";
        }

    }

}
