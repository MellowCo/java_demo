package domain;

import java.io.NotActiveException;
import java.rmi.NotBoundException;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-22 16:22
 */
public class Person extends People{

    private Integer id;
    private String name;
    public Integer age;

    static {
        System.out.println("static.......");
    }

    private String priMe(String name,Integer age){
        System.out.println("private.....");
        return name;
    }

    public String pubMe(String name) throws NotBoundException, NotActiveException {
        System.out.println("public.....");
        return name;
    }

    private Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
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
