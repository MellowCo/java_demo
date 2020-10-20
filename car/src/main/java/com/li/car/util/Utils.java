package com.li.car.util;

import com.li.car.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;

/**
 * @Description: 工具类
 * @Author: li
 * @Create: 2020-03-21 13:14
 */
public class Utils {

    /***
     * @Description: 打印信息
     * @Param: []
     * @return: void
     */
    public static void printMsg(String className, Object msg) {
        System.out.println("============================");
        System.out.println("[" + className + "]->" + msg);
        System.out.println("============================");
    }

    /**
    * @Description: 对注册的密码进行加密
    * @Param: [pwd 原始密码]
    * @return: java.lang.String 返回MD5加密1024次后的密码
    */
    public static String md5Code(String pwd){
        SimpleHash hash = new SimpleHash("MD5",pwd,null,1024);
        return hash.toString();
    }

    /**
    * @Description: 从shiro中 获取当前用户
    * @Param: []
    * @return: User
    */
    public static User securityUser(){
        Subject subject = SecurityUtils.getSubject();
        return (User)subject.getPrincipal();
    }
}
