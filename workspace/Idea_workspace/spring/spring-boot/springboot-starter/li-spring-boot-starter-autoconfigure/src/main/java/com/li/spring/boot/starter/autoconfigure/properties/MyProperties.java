package com.li.spring.boot.starter.autoconfigure.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-08 17:18
 */
@ConfigurationProperties(prefix = "com.li")
public class MyProperties {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
