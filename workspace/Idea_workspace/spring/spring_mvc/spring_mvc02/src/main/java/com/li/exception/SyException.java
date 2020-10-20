package com.li.exception;

/**
 * @Program: spring_mvc02
 * @ClassName: SyException
 * @Description: 自定义异常
 * @Author: li
 * @Create: 2019-08-03 17:11
 */
public class SyException extends Exception{
    private String exceptionMsg;

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public SyException(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }
}
