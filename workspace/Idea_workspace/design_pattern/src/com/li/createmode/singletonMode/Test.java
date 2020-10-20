package com.li.createmode.singletonMode;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-10-02 10:20
 */
public class Test {
}

class Single1 {
    private Single1()

    {
    }

    private final static Single1 single = new Single1();

    public static Single1 getInstance() {
        return single;
    }
}

class Single2 {

    private Single2() {
    }

    private static Single2 single2;

    public static synchronized Single2 getInstance() {
        if (single2 == null) {
            single2 = new Single2();
        }

        return single2;
    }

}

class Single3 {
    private Single3() {

    }

    private static Single3 single3;

    public static Single3 getInstance() {
        if (single3 == null) {
            synchronized (Single3.class) {

                single3 = new Single3();
            }
        }

        return single3;
    }
}

class DclSing{
    private static volatile DclSing sing;

    private DclSing(){}

    public static DclSing getInstance(){

        if (sing == null){
            synchronized (DclSing.class){
                if (sing == null){
                    sing = new DclSing();
                }
            }
        }

        return sing;
    }



}