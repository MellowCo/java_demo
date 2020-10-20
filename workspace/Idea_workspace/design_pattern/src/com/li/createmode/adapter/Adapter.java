package com.li.createmode.adapter;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-01-09 13:27
 */

//类适配器
public class Adapter extends Adaptee implements Target{

    @Override
    public void handleReq() {
        super.request();
    }


}
