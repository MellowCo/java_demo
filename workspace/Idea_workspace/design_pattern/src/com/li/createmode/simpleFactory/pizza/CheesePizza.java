package com.li.createmode.simpleFactory.pizza;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-10-01 16:32
 */
public class CheesePizza extends Pizza{
    @Override
    public void prepare() {
        setName("cheese");
        System.out.println("cheesepizza....");
    }
}
