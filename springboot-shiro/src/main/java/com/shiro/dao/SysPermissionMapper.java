package com.shiro.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.shiro.entity.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author dctang
 * @since 2020-07-22
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * 查询菜单权限
     * @param roleId
     * @return
     */
    List<SysPermission> getPermissions(Integer roleId);
}
