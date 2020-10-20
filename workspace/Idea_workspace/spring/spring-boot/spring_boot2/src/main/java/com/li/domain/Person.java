package com.li.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-08-24 20:17
 */
// @Validated
// @Component
@PropertySource(value = {"classpath:config/person.properties"})
@ConfigurationProperties(prefix = "person")
public class Person {

    private String name;

    private Integer age;
    private boolean sex;
    // private Date birthday;
    //
    // private Map<String,Object> maps;
    // private List<Object> lists;
    // private Dog dog;


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

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

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
