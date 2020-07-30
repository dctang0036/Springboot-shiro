package com.shiro.config;

import com.shiro.entity.SysPermission;
import com.shiro.entity.SysRole;
import com.shiro.entity.SysUser;
import com.shiro.service.SysPermissionService;
import com.shiro.service.SysRoleService;
import com.shiro.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;


import javax.annotation.Resource;
import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysRoleService sysRoleService;

    @Resource
    private SysPermissionService sysPermissionService;

    /**
     * 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        // 获取用户的输入账号
        String userName = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
        // 通过userName从数据库中查找SysUser对象
        // 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        SysUser sysUser = sysUserService.getByUserName(userName);
        System.out.println("------>> sysUser = " + sysUser);
        if (sysUser == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                sysUser, //这里传入的是sysUser对象，比对的是用户名，直接传入用户名也没错，但是在授权部分就需要自己重新从数据库里取权限
                sysUser.getPassWord(), //密码
                ByteSource.Util.bytes(sysUser.getCredentialsSalt()), //salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;

    }

    //权限信息，包括角色以及权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //如果身份认证的时候没有传入User对象，这里只能取到userName
        //也就是SimpleAuthenticationInfo构造的时候第一个参数传递需要User对象
        SysUser sysUser  = (SysUser) principals.getPrimaryPrincipal();

        List<SysRole> sysRoleList = sysRoleService.getRoleList(sysUser.getUserName());

        for(SysRole role : sysRoleList){
            authorizationInfo.addRole(role.getRole());

            List<SysPermission> sysPermissionList = sysPermissionService.getPermissions(role.getRoleid());
            for(SysPermission p : sysPermissionList){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }
}
