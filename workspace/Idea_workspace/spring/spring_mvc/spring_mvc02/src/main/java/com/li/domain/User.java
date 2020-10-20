package com.li.domain;

import javax.validation.constraints.NotNull;

/**
 * @Program: spring_mvc02
 * @ClassName: User
 * @Description:
 * @Author: li
 * @Create: 2019-08-02 13:41
 */
public class User {
    @NotNull
    private String name;
    private String sex;
    private Integer age;

    public User(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
