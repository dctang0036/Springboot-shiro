package com.shiro.dao;

import com.shiro.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author dctang
 * @since 2020-07-22
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 查询角色列表
     * @param userName
     * @return
     */
    List<SysRole> getRoles(String userName);

}
