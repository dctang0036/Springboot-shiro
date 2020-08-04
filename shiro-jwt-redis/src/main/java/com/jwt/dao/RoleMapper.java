package com.jwt.dao;

import com.jwt.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author dctang
 * @since 2020-07-30
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 查询角色列表
     * @param username
     * @return
     */
    List<String> getRolesByUserName(@Param("username") String username);

}
