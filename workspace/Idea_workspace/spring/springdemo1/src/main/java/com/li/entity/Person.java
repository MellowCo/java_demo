package com.li.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component("person")
public class Person {
    @Value("li")
    private String name;
    @Value("12")
    private Integer age;
    @Resource(name="user")
    private User user;

    // public void setName(String name) {
    //     this.name = name;
    // }
    //
    // public void setAge(Integer age) {
    //     this.age = age;
    // }
    //
    // public void setUser(User user) {
    //     this.user = user;
    // }

    public void savePerson() {
        System.out.println( "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", user=" + user +
                '}');
    }
}
