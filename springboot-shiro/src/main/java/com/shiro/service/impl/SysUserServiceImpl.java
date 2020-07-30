package com.shiro.service.impl;

import com.shiro.entity.SysUser;
import com.shiro.dao.SysUserMapper;
import com.shiro.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author dctang
 * @since 2020-07-22
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getByUserName(String userName) {
        SysUser sysUser = sysUserMapper.getByUserName(userName);
        return sysUser;
    }
}
