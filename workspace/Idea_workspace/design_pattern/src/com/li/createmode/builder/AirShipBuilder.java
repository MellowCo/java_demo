package com.li.createmode.builder;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-01-08 16:08
 */
public interface AirShipBuilder {

    Engine createEngine();

    MainBody createMainBody();
}
