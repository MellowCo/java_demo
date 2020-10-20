package com.li.classLoader;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-02-12 15:34
 */
public class Test7 {
    static {
        System.out.println("test7 block");
    }

    public static void main(String[] args) {
        System.out.println(Child7.b);
        //test7 block
        //parent7 block
        //child7 block
        //8
    }
}


class Parent7 {
    static int a = 7;
    static{
        System.out.println("parent7 block");
    }
}

class Child7 extends Parent7{
    static int b = 8;
    static {
        System.out.println("child7 block");
    }
}