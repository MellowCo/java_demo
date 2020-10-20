package entity;

/**
 * @author li
 * @version 1.0
 * @ClassName Person
 * @date 2019/7/14 17:21
 */

public class Person {
    private int id;
    private String name;
    private String sex;
    private int age;
    private int money;

    public Person(int id, String name, String sex, int age, int money) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.money = money;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
