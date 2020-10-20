package com.li.classLoader;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-02-12 15:43
 */
public class Test9 {
    public static void main(String[] args) {
        System.out.println(Child9.a);

        Child9.p9();

        //parent9 block
        //7
        //p9 static function
    }
}

class Parent9 {
    static int a = 7;

    static {
        System.out.println("parent9 block");
    }

    static void p9() {
        System.out.println("p9 static function");
    }
}

class Child9 extends Parent9 {
    static int b = 8;

    static {
        System.out.println("child9 block");
    }
}
