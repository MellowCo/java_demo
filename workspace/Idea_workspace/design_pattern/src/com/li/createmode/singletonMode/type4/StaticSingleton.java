package com.li.createmode.singletonMode.type4;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-30 15:41
 */
public class StaticSingleton {
    private StaticSingleton() {
    }

    private static class Singleton{
        private static final StaticSingleton SINGLETON = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return Singleton.SINGLETON;
    }

    public static void main(String[] args) {
        StaticSingleton instance = StaticSingleton.getInstance();
        StaticSingleton instance2 = StaticSingleton.getInstance();
        System.out.println(instance == instance2);
    }
}
