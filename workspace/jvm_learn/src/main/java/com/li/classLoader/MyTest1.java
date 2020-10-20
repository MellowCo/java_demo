package com.li.classLoader;

/**
 * @Description: 对于静态字段来说，只有直接定义了该字段的类才会被初始化
 * @Author: li
 * @Create: 2020-02-09 14:54
 */
public class MyTest1 {
    public static void main(String[] args) {
        System.out.println(Child1.str);
        //parent1 static block
        //parent1 str

        //System.out.println(Child1.str2);
        //parent1 static block
        //child static block
        //child str2
    }
}

class Parent1{
    public static String str = "parent1 str";

    static {
        System.out.println("parent1 static block");
    }
}

class Child1 extends Parent1{
    public static String str2 = "child str2";

    static{
        System.out.println("child static block");
    }
}