package com.li.springboot_web.exception;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-03 14:12
 */
public class UserNotExistException extends RuntimeException{

    public UserNotExistException() {
        super("用户不存在");
    }
}
