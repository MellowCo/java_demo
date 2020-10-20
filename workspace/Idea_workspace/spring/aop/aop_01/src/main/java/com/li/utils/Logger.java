package com.li.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {

    @Pointcut("execution(* com.li.service.impl.*.*(..))")
    private void p() {

    }

    @Before("p()")
    void beforeLog() {
        System.out.println("开启日志。。。。。。。");
    }

    @AfterReturning("p()")
    void afteringLog() {
        System.out.println("后置通知......");
    }

    @AfterThrowing("p()")
    void thowingLog() {
        System.out.println("异常通知......");
    }

    @After("p()")
    void afterLog() {
        System.out.println("最终通知......");
    }

    @Around("p()")
    Object around(ProceedingJoinPoint pj) {
        Object val = null;
        try {
            Object[] args = pj.getArgs();

            System.out.println("around 前置");

            val = pj.proceed();

            System.out.println("around 后置");
            return val;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("around 异常");
        }finally {
            System.out.println("around 最终");
        }
        return null;
    }
















    public Object aroundLog(ProceedingJoinPoint pd) {
        Object val = null;

        try {
            Object[] args = pd.getArgs();

            System.out.println("前置通知");
            val = pd.proceed(args);
            System.out.println("后置通知");
            return val;
        } catch (Throwable throwable) {
            System.out.println("异常通知");
            throwable.printStackTrace();
        } finally {
            System.out.println("最终通知");
        }
        return null;
    }

}
