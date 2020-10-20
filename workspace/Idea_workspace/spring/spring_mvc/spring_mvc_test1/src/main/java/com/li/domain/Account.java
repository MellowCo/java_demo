package com.li.domain;

import java.util.Date;

/**
 * @Program: spring_mvc_test1
 * @ClassName: Account
 * @Description:
 * @Author: li
 * @Create: 2019-07-28 16:49
 */
public class Account {
    private String name;
    private Integer money;
    private Date date;

    public Account() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account(String name, Integer money, Date date) {
        this.name = name;
        this.money = money;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", date=" + date +
                '}';
    }
}
