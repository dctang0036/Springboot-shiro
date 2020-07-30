package com.shiro.service;

import com.shiro.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author dctang
 * @since 2020-07-22
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 通过用户名查询到用户信息
     * @param userName
     * @return
     */
    SysUser getByUserName(String userName);

}
