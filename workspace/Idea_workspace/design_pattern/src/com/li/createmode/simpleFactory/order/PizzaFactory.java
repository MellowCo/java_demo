package com.li.createmode.simpleFactory.order;

import com.li.createmode.simpleFactory.pizza.CheesePizza;
import com.li.createmode.simpleFactory.pizza.GreekPizza;
import com.li.createmode.simpleFactory.pizza.Pizza;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-10-01 16:35
 */
public class PizzaFactory {

    public static Pizza createPizza(String type){
        Pizza pizza = null;
        if ("geek".equals(type)){
            pizza = new GreekPizza();
        } else if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        }
        return pizza;
    }

}
