package com.shiro.jwt.service;

import com.shiro.jwt.domain.UserInfo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserInfo selectByName(String userName) {
        UserInfo userInfo = new UserInfo(userName, "12345", "admin", "vip");

        return userInfo;
    }
}
