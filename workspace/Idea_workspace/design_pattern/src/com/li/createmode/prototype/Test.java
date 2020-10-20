package com.li.createmode.prototype;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-10-02 16:06
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person("li", 12, "man",new Person("wang",13,"woman"));

        Person person1 = new Person(person.getName(), person.getAge(), person.getSex());
        Person person2 = new Person(person.getName(), person.getAge(), person.getSex());
        Person person3 = new Person(person.getName(), person.getAge(), person.getSex());
        Person person4 = new Person(person.getName(), person.getAge(), person.getSex());

        Person p5 = (Person) person.clone();
        // System.out.println(p5 == person);
        // System.out.println(person);
        System.out.println(person.getFriend().hashCode());
        System.out.println(p5.getFriend().hashCode());
    }
}
