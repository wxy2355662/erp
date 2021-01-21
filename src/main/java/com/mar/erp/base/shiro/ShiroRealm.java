package com.mar.erp.base.shiro;


import com.mar.erp.personnel.model.Ataff;
import com.mar.erp.personnel.service.IAtaffService;
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

    @Autowired
    private IAtaffService ataffService;


    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       //获取登录用户的username
        String username = principalCollection.getPrimaryPrincipal().toString();

        Set<String> roles = ataffService.findRole(username);
        Set<String> permissions = ataffService.findPermissions(username);
        //创建SimpleAuthorizationInfo
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);

        return simpleAuthorizationInfo;

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
        String username = authenticationToken.getPrincipal().toString();

//        //根据账号实现登录验证
        Ataff ataff = ataffService.queryByLogin(username);
        //没有账号就抛出异常
        if(null==ataff)
            throw  new UnknownAccountException();

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                ataff.getAtaUsername(),
                ataff.getAtaPassword(),
                this.getName()
        );

        return simpleAuthenticationInfo;


    }
}
