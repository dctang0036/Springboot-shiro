package com.jwt.dao;

import com.jwt.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author dctang
 * @since 2020-07-30
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 查询权限信息列表
     * @param roleName
     * @return
     */
    List<Permission> getPermissions(@Param("roleName") String roleName);
}
