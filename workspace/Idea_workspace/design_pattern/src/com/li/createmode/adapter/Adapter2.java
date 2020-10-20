package com.li.createmode.adapter;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-01-09 13:27
 */

//对象适配器
public class Adapter2 implements Target{

    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleReq() {
        adaptee.request();
    }


}
