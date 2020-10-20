package com.li.createmode.adapter;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-01-09 13:26
 */
public class Client {

    public void test(Target t){
        t.handleReq();
    }

    public static void main(String[] args) {
        new Client().test(new Adapter());

        new Client().test(new Adapter2(new Adaptee()));
    }
}
