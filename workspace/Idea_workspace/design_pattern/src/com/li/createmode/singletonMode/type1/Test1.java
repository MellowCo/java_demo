package com.li.createmode.singletonMode.type1;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-29 15:57
 */

public class Test1 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance == instance2);

        Singleton2 instance3 = Singleton2.getInstance();
        Singleton2 instance4 = Singleton2.getInstance();

        System.out.println(instance3 == instance4);
    }
}

//饿汉式(静态变量)
class Singleton {

    //1. 构造器私有化, 防止直接new
    private Singleton() {
    }

    //2.本类内部创建对象实例
    private final static Singleton instance = new Singleton();

    //3. 提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }
}

//饿汉式(静态变量)
class Singleton2{

    //1. 构造器私有化, 防止直接new
    private Singleton2() {
    }

    //2.本类内部创建对象实例
    private  static Singleton2 instance;

    static {
        // 在静态代码块中，创建单例对象
        instance = new Singleton2();
    }

    //3. 提供一个公有的静态方法，返回实例对象
    public static Singleton2 getInstance() {
        return instance;
    }
}



