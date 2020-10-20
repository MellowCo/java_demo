package com.li.createmode.singletonMode.type2;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-30 15:03
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println("懒汉式线程不安全");
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);

        System.out.println("懒汉式线程安全，同步方法");
        Singleton2 singleton3 = Singleton2.getInstance();
        Singleton2 singleton4 = Singleton2.getInstance();
        System.out.println(singleton3 == singleton4);

        System.out.println("懒汉式线程安全，同步方法");
        Singleton3 singleton5 = Singleton3.getInstance();
        Singleton3 singleton6 = Singleton3.getInstance();
        System.out.println(singleton5 == singleton6);

    }
}

class Singleton{
    private Singleton(){
    }

    private static Singleton singleton;

    //当调用getInstance() 才会创建单例对象
    public static Singleton getInstance(){
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

class Singleton2{
    private Singleton2(){
    }

    private static Singleton2 singleton;

    //加入同步方法，解决线程不安全问题
    public static synchronized Singleton2 getInstance() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}

class Singleton3{
    private Singleton3(){
    }

    private static Singleton3 singleton;

    public static  Singleton3 getInstance() {
        if (singleton == null) {
            synchronized (Singleton3.class){
                singleton = new Singleton3();
            }
        }
        return singleton;
    }
}

