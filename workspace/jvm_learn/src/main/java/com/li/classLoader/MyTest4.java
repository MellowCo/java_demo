package com.li.classLoader;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-02-09 16:32
 */
public class MyTest4 {
    public static void main(String[] args) {
        // Parent4 p = new Parent4();
        // Parent4 p2 = new Parent4();
        //parent4 static block

        Parent4[] p = new Parent4[2];
        System.out.println(p.getClass()); //class [Lcom.li.classLoader.Parent4;
        System.out.println(p.getClass().getSuperclass()); //class java.lang.Object
    }
}


class Parent4{
    static {
        System.out.println("parent4 static block");
    }
}
