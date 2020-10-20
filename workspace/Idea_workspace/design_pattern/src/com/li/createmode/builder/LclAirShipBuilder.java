package com.li.createmode.builder;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-01-08 16:11
 */
public class LclAirShipBuilder implements AirShipBuilder {
    @Override
    public Engine createEngine() {
        System.out.println("lcl 发动机 构建");
        return new Engine("lcl 发动机");
    }

    @Override
    public MainBody createMainBody() {
        System.out.println("lcl 主体 构建");
        return new MainBody("lcl 主体");
    }
}
