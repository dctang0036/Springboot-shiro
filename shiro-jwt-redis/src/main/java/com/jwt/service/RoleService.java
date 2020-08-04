package com.jwt.service;

import com.jwt.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author dctang
 * @since 2020-07-30
 */
public interface RoleService extends IService<Role> {

    /**
     * 通过用户名获取用户角色集合
     *
     * @param username 用户名
     * @return 角色集合
     */
    Set<String> getUserRolesSet(String username);
}
