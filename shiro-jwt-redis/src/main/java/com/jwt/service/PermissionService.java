package com.jwt.service;

import com.jwt.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author dctang
 * @since 2020-07-30
 */
public interface PermissionService extends IService<Permission> {

    /**
     * 通过角色获取用户权限集合
     * @param roleSet 角色集合
     * @return 权限集合
     */
    Set<String> getRolePermissionsSet(Set<String> roleSet);

}
