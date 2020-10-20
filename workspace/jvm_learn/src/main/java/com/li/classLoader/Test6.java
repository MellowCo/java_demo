package com.li.classLoader;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-02-12 14:59
 */
public class Test6 {
    public static void main(String[] args) {
        Class clazz = String.class;
        System.out.println(clazz.getClassLoader()); //null


        System.out.println(C.class.getClassLoader());
        //sun.misc.Launcher$AppClassLoader@18b4aac2
    }
}

class C{

}
