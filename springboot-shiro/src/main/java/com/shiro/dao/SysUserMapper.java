package com.shiro.dao;

import com.shiro.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author dctang
 * @since 2020-07-22
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser getByUserName(String userName);


}
