package com.li.createmode.singletonMode.type5;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-30 15:53
 */
public class EnumSingleton {
    private EnumSingleton() {
    }

    public static EnumSingleton getInstance() {
        return EnumHolder.INSTANCE.getInstance();
    }

    private enum EnumHolder {
        INSTANCE;
        private EnumSingleton instance = null;

        private EnumHolder() {
            instance = new EnumSingleton();
        }

        private EnumSingleton getInstance() {
            return instance;
        }
    }

    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.getInstance();
        EnumSingleton instance2 = EnumSingleton.getInstance();
        System.out.println(instance == instance2);
    }
}
