package com.jwt.service.impl;

import com.jwt.constant.CommonConstant;
import com.jwt.entity.Permission;
import com.jwt.dao.PermissionMapper;
import com.jwt.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jwt.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author dctang
 * @since 2020-07-30
 */
@Service
@Slf4j
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 通过角色获取用户权限集合
     * @param roleSet 角色集合
     * @return 权限集合
     */
    @Override
    @Cacheable(value = CommonConstant.LOGIN_USER_CACHERULES_PERMISSION, key = "'Roleset_' + #roleSet")
    public Set<String> getRolePermissionsSet(Set<String> roleSet) {
        Set<String> permissionSet = new HashSet<>();

        for (String roleName : roleSet) {
            // 根据角色名称查询权限列表
            List<Permission> permissionList = permissionMapper.getPermissions(roleName);
            for (Permission permission : permissionList) {
                if (CommonUtils.isNotEmpty(permission.getPerms())) {
                    permissionSet.add(permission.getPerms());
                }
            }
        }
        log.info("----通过数据库读取用户拥有的权限Perms----roleName： " + roleSet.toString() + ",Perms size: "
                + (permissionSet == null ? 0 : permissionSet.size()));
        return permissionSet;
    }
}
