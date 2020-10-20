package com.li.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @Program: mybatis_manyToMany
 * @ClassName: Role
 * @Description:
 * @Author: li
 * @Create: 2019-08-19 13:09
 */
public class Role implements Serializable {
    private Integer id;
    private String name;
    private String desc;

    private List<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", users=" + users +
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
