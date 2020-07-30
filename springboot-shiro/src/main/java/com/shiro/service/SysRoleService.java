package com.shiro.service;

import com.shiro.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author dctang
 * @since 2020-07-22
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 通过用户名查询角色信息列表
     * @param userName
     * @return
     */
    List<SysRole> getRoleList(String userName);
}
