package 装饰类;

public class da {
    public static void main(String[] args) {
        student s = new student("aaa",12);
        System.out.println(s);
    }
}

class student{
    private String name;
    private int age;

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public student() {
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}