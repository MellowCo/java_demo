package com.li.createmode.bridge;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-01-09 14:53
 */
public interface Brand {
    void sale();
}

class Lenovo implements Brand{

    @Override
    public void sale() {
        System.out.println("lenovo");
    }
}

class Dell implements Brand{
    @Override
    public void sale() {
        System.out.println("dell");
    }
}
