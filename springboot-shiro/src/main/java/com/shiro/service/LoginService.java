package com.shiro.service;

import com.shiro.domain.LoginResult;

public interface LoginService {
    /**
     * 登陆
     * @param userName
     * @param passWord
     * @return
     */
    LoginResult login(String userName, String passWord);

    // 登陆注销
    void logout();
}
