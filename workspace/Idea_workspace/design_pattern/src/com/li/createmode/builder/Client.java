package com.li.createmode.builder;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-01-08 16:18
 */
public class Client {

    public static void main(String[] args) {
        AirShipDirector director = new LclAirShipDirector(new LclAirShipBuilder());

        AirShip airShip = director.createAirShip();
        System.out.println(airShip);

        Map<Object, Object> map = new HashMap<>();

    }
}
