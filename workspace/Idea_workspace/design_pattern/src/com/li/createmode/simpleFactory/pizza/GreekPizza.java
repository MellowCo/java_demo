package com.li.createmode.simpleFactory.pizza;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-10-01 16:33
 */
public class GreekPizza extends Pizza{
    @Override
    public void prepare() {
        setName("Greek");
        System.out.println("greekpizza......");
    }
}
