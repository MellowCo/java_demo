package com.li.car.config.shiro;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.li.car.entity.User;
import com.li.car.exception.BlackUserException;
import com.li.car.services.impl.RoleServiceImpl;
import com.li.car.services.impl.UserServiceImpl;
import com.li.car.util.Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-03-21 14:41
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoleServiceImpl roleService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();

        Utils.printMsg("UserRealm->isAuthenticated:", subject.isAuthenticated());
        Utils.printMsg("UserRealm->isRemembered:", subject.isRemembered());


        User user = (User) principals.getPrimaryPrincipal();

        if (user != null) {
            //给资源进行授权
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

            //添加角色
            String rid = user.getRid();

            String roleName = roleService.getById(rid).getRoleName();
            Utils.printMsg("UserRealm", "添加角色" + roleName);
            info.addRole(roleName);

            return info;
        }

        return null;

    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //获取用户名
        UsernamePasswordToken passwordToken = (UsernamePasswordToken) token;
        String userName = passwordToken.getUsername();

        Utils.printMsg("UserRealm", "查询用户登录信息");
        //查询数据库
        User user = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getEmail, userName));


        if (user == null) {
            //用户名不存在
            //shiro底层会抛出UnKnowAccountException
            return null;
        }

        if(user.getStatus() == -1){
            throw new BlackUserException();
        }

        //2、判断密码, 这里的user是principal
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPwd(), getName());

        return info;
    }

}
