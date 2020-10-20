package com.li.createmode.singletonMode.type3;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-30 15:27
 */
public class DCLSingleton {
    private static volatile DCLSingleton dclSingleton;

    private DCLSingleton() {
    }

    public static DCLSingleton getInstance() {
        if (dclSingleton == null) {
            synchronized (DCLSingleton.class) {
                if (dclSingleton == null) {
                    dclSingleton = new DCLSingleton();
                }
            }
        }
        return dclSingleton;
    }

    public static void main(String[] args) {
        DCLSingleton dclSingleton1 = DCLSingleton.getInstance();
        DCLSingleton dclSingleton2 = DCLSingleton.getInstance();
        System.out.println(dclSingleton1 == dclSingleton2);

    }
}

