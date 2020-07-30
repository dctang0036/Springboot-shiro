package com.shiro.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ShiroController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String shiroLogin() {
        System.out.println("shiro login");
        return "login";
    }

    @RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
    public String shiroUnauthorized() {
        System.out.println("shiro unauthorized");
        return "unauthorized";
    }
}
