package com.shiro.service.impl;

import com.shiro.domain.LoginResult;
import com.shiro.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public LoginResult login(String userName, String passWord) {
        LoginResult loginResult = new LoginResult();
        if (userName == null || passWord == null) {
            loginResult.setLogin(false);
            loginResult.setResult("用户名为空！");
            return loginResult;
        }

        String msg = "";
        // 1、获取Subject实例对象
        Subject currentUser = SecurityUtils.getSubject();

        // 2、判断当前用户是否已经登陆
        /*if (currentUser.isAuthenticated() == false) {
            loginResult.setLogin(false);
            loginResult.setResult("用户已经登陆");
            return loginResult;
        }*/

        // 3、将用户名和密码封装到UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);

        // 4、认证（登陆认证）
        try {
            currentUser.login(token); // 传到MyAuthorizingRealm类中的方法进行认证
            Session session = currentUser.getSession();
            session.setAttribute("userName", userName);
            loginResult.setLogin(true);
            return loginResult;

            // shiro认证失败后将抛出异常
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            msg = "UnknownAccountException -- > 账号不存在：";
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            msg = "IncorrectCredentialsException -- > 密码不正确：";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            msg = "用户验证失败";
        }

        loginResult.setLogin(false);
        loginResult.setResult(msg);

        return loginResult;

    }

    @Override
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}
