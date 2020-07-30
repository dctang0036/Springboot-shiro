package com.shiro.service;

import com.shiro.entity.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author dctang
 * @since 2020-07-22
 */
public interface SysPermissionService extends IService<SysPermission> {

    /**
     * 查询权限信息
     * @param roleId
     * @return
     */
    List<SysPermission> getPermissions(Integer roleId);
}
