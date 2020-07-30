package com.shiro.service.impl;

import com.shiro.entity.SysPermission;
import com.shiro.dao.SysPermissionMapper;
import com.shiro.service.SysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author dctang
 * @since 2020-07-22
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<SysPermission> getPermissions(Integer roleId) {
        List<SysPermission> sysPermissionList = sysPermissionMapper.getPermissions(roleId);

        return sysPermissionList;
    }
}
