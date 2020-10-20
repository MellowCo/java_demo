package com.li.classLoader;

import java.util.UUID;

/**
 * @Description: 当一个常量的值并非编译期间可以确定的，那么其值就不会被放到调用类的常量池中，
 * 这时在程序运行时，会导致主动使用这个常量所在的类，导致这个类被初始化
 * @Author: li
 * @Create: 2020-02-09 16:26
 */
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(Parent3.str);
        //parent3 static block
        //978c7b97-e7ca-4226-ad09-493e441d6043
    }
}

class Parent3{
    public static final String str = UUID.randomUUID().toString();

    static{
        System.out.println("parent3 static block");
    }
}
