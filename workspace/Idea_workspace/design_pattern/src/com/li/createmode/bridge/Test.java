package com.li.createmode.bridge;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-01-09 14:59
 */
public class Test {

    public static void main(String[] args) {
        Computer c = new Desktop(new Lenovo());
        c.sale();
    }
}
