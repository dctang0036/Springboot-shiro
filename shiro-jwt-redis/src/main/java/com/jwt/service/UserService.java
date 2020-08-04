package com.jwt.service;

import com.jwt.entity.Role;
import com.jwt.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jwt.utils.Result;

import java.util.Set;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author dctang
 * @since 2020-07-30
 */
public interface UserService extends IService<User> {

    User getUser();

    User getUserByName(String name);

    /**
     * 校验用户是否有效
     *
     * @param user
     * @return
     */
    Result checkUserIsEffective(User user);


}
