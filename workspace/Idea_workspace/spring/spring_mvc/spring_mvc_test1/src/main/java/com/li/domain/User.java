package com.li.domain;

/**
 * @Program: spring_mvc_test1
 * @ClassName: User
 * @Description: user
 * @Author: li
 * @Create: 2019-07-28 15:45
 */
public class User {
    private String name;
    private int age;
    private String password;
    private Account account;

    public Account getAccount() {
        return account;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", account=" + account +
                '}';
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

