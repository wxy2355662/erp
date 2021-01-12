package com.mar.erp.base.shiro;


import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * 自定义realm 提供jdbc数据源
 */
public class ShiroRealm extends AuthorizingRealm {


    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        //获取登录用户的username
//        String username = principalCollection.getPrimaryPrincipal().toString();
//
//        //根据username获取用户的角色
//        Set<String> roles = sysUserServlet.findRoles(username);
//
//        //根据username获取用户的权限
//        Set<String> permissions = sysUserServlet.findPermissions(username);
//
//        //创建SimpleAuthorizationInfo
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.setRoles(roles);
//        simpleAuthorizationInfo.setStringPermissions(permissions);
//
//
//        return simpleAuthorizationInfo;
        return null;
    }

    /**
     * 认证 调用subject.login(token) 时被调用
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//       //获取登录的账号和密码信息
//        String username = authenticationToken.getPrincipal().toString();
//        String password = authenticationToken.getCredentials().toString();
//        System.out.println("username:"+username);
//        System.out.println("password:"+password);
//        //根据账号实现登录验证
//        SysUser sysUser = sysUserServlet.userLogin(username);
//        //判断用户是否为null
//        if(null==sysUser)
//            throw  new UnknownAccountException("账号错误");
//
//        //创建SimpleAuthenticationInfo 验证对象 用于验证令牌里的数据是否和传入的数据匹配
//        //令牌里的密码会进行编码
//        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
//                sysUser.getUsername(),
//                sysUser.getPassword(),
//                ByteSource.Util.bytes(sysUser.getSalt()),
//                this.getName()
//        );
//
//
//
//        return simpleAuthenticationInfo;
        return null;
    }
}
