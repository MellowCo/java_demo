package com.li.createmode.simpleFactory.store;

import com.li.createmode.simpleFactory.order.OrderPizza;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-10-01 16:41
 */
public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza("cheese");
        new OrderPizza("geek");
        new OrderPizza("");
    }
}
