package com.li.createmode.prototype;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-10-02 16:05
 */
public class Person implements Cloneable{
    private String name;
    private int age;
    private String sex;
    private Person friend;

    public Person(String name, int age, String sex, Person friend) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.friend = friend;
    }

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        person.friend = (Person) friend.clone();
        return person;
    }

    public Person getFriend() {
        return friend;
    }

    public void setFriend(Person friend) {
        this.friend = friend;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", friend=" + friend +
                '}';
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
