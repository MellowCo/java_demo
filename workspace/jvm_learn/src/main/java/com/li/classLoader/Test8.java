package com.li.classLoader;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-02-12 15:40
 */
public class Test8 {
    static {
        System.out.println("test8 block");
    }

    public static void main(String[] args) {
        Parent8 parent8;
        System.out.println("-----------");

        parent8 = new Parent8();
        System.out.println("-----------");

        System.out.println(parent8.a);
        System.out.println("-----------");

        System.out.println(Child8.b);
        System.out.println("-----------");

        //test8 block
        // -----------
        // parent8 block
        // -----------
        // 7
        // -----------
        // child8 block
        // 8
        // -----------
    }
}


class Parent8 {
    static int a = 7;
    static{
        System.out.println("parent8 block");
    }
}

class Child8 extends Parent8{
    static int b = 8;
    static {
        System.out.println("child8 block");
    }
}
