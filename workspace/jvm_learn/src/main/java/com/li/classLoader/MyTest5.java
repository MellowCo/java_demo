package com.li.classLoader;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-02-09 17:04
 */
public class MyTest5 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        System.out.println("i="+singleton.i); //1
        System.out.println("j="+singleton.j); //0
    }
}

class Singleton{
    public static int i;

    public static Singleton singleton = new Singleton();
    private Singleton(){
        i++;
        j++;
        System.out.println(i); //1
        System.out.println(j); //1
    }

    public static int j = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}
