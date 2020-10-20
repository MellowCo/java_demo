package com.li.springboot.jdbc.domain;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-06 18:45
 */
public class User {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
