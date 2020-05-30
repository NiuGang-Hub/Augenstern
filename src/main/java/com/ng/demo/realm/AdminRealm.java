package com.ng.demo.realm;

import com.ng.demo.enums.ResultEnum;
import com.ng.demo.enums.StateEnums;
import com.ng.demo.exception.BlogException;
import com.ng.demo.pojo.Admin;
import com.ng.demo.pojo.User;
import com.ng.demo.service.AdminService;
import com.ng.demo.service.UserService;
import com.ng.demo.token.UsernamePasswordToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 处理管理员的登录和授权逻辑
 *
 * @Author: 杨德石
 * @Date: 2020/2/9 15:45
 * @Version 1.0
 */
public class AdminRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    /**
     * 授权方法
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return new SimpleAuthorizationInfo();
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        int state = usernamePasswordToken.getState();
        if (state == StateEnums.ADMIN.getCode()) {
            Admin admin = adminService.getByUsername(username);
            if (admin == null) {
                // 用户不存在
                throw new BlogException(ResultEnum.ERROR.getCode(), "用户不存在！");
            }
            return new SimpleAuthenticationInfo(admin, admin.getPassword(), this.getName());
        } else {
            User user = userService.selectByUserName(username);
            if (user == null) {
                // 用户不存在
                throw new BlogException(ResultEnum.ERROR.getCode(), "用户不存在！");
            }
            return new SimpleAuthenticationInfo(user, user.getPassWord(), this.getName());
        }
    }
}
