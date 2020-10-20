package com.li.classLoader;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-02-12 15:48
 */
public class Test10 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = loader.loadClass("com.li.classLoader.B");

        System.out.println("------------");

        clazz = Class.forName("com.li.classLoader.B");
        System.out.println(clazz);

        //------------
        // b block
        // class com.li.classLoader.B
    }
}

class B{
    static {
        System.out.println("b block");
    }
}
