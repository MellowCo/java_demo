package com.li.springboot.es.domain;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-14 12:10
 */
@Document(indexName = "lies",type = "admin")
public class Admin {

    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

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
