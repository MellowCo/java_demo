package com.li.classLoader;

/**
 * @Description: 常量在编译阶段会存入调用这个常量的方法所在的类的常量池中，
 * 本质上，调用类并没有直接引用到定义常量的类，因此并不会触发定义常量的类的初始化
 * @Author: li
 * @Create: 2020-02-09 15:36
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(Parent2.str);
    }
}

class Parent2{
    public static final String str = "hello world";

    static{
        System.out.println("parent2 static block");
    }
}
