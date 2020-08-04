package com.jwt.service.impl;

import com.jwt.constant.CommonConstant;
import com.jwt.entity.Role;
import com.jwt.dao.RoleMapper;
import com.jwt.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author dctang
 * @since 2020-07-30
 */
@Service
@Slf4j
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 读取用户拥有的角色
     * @param username 用户名
     * @return
     */
    @Override
    @Cacheable(value = CommonConstant.LOGIN_USER_CACHERULES_ROLE, key = "'Roles_' + #username")
    public Set<String> getUserRolesSet(String username) {
        List<String> roles = roleMapper.getRolesByUserName(username);
        log.info("----通过数据库读取用户拥有的角色Rules----username： " + username + ", Roles size: " + (roles == null ? 0 : roles.size()));
        return new HashSet<>(roles);
    }
}
