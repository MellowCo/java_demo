package com.li;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Demo4 {

    public static void main(String[] args) {
        Person person1 = new Person("li", 12);
        Person person2 = new Person("wang", 19);
        Person person3 = new Person("qian", 18);
        Person person4 = new Person("ss", 4);

        Set<Person> persons = new HashSet<>();
        persons.add(person1);
        persons.add(person2);

        Set<Person> ps = new TreeSet<>();
        ps.add(person1);
        ps.add(person2);
        ps.add(person3);
        ps.add(person4);

        System.out.println(ps);

        System.out.println(persons);
    }
}


class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Person o) {
        return this.name == o.getName() ? 0 : this.age - o.getAge();
    }


}