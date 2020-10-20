package com.li.createmode.builder;

/**
 * @Description: 飞船的引擎
 * @Author: li
 * @Create: 2020-01-08 16:04
 */
public class Engine {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Engine(String name) {
        this.name = name;
    }
}
