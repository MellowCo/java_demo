package com.li.spring.boot.starter.autoconfigure.services;

import com.li.spring.boot.starter.autoconfigure.properties.MyProperties;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-08 17:22
 */
public class MyServices {

    MyProperties properties;

    public MyServices(MyProperties properties) {
        this.properties = properties;
    }

    public MyProperties getProperties() {
        return properties;
    }

    public void setProperties(MyProperties properties) {
        this.properties = properties;
    }

    public String say(){
        return properties.getName() + "-" + properties.getAge();
    }
}
