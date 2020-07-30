package com.shiro.service.impl;

import com.shiro.entity.SysRole;
import com.shiro.dao.SysRoleMapper;
import com.shiro.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author dctang
 * @since 2020-07-22
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> getRoleList(String userName) {
        List<SysRole> sysRoleList = sysRoleMapper.getRoles(userName);

        return sysRoleList;
    }
}
