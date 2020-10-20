package com.li.createmode.simpleFactory.order;

import com.li.createmode.simpleFactory.pizza.Pizza;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-10-01 16:37
 */
public class OrderPizza {

    public OrderPizza(String type) {
        Pizza pizza = PizzaFactory.createPizza(type);
        if (pizza == null) {
            System.out.println("订购失败");
        } else {
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }
    }
}
