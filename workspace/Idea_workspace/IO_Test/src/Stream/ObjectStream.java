package Stream;

import java.io.*;
import java.util.Date;

public class ObjectStream {

    static void input() throws IOException, ClassNotFoundException {
        File file = new File("dest.text");
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        student s1 = (student) ois.readObject();
        student s2 = (student) ois.readObject();
        System.out.println(s1.getName() +"---" +s1.getAge());
        System.out.println(s2.getName() +"---" +s2.getAge());
        Date t1 = (Date) ois.readObject();
        System.out.println(t1);
        System.out.println(ois.readUTF());
        ois.close();
    }


    static void output() throws IOException {
        File file = new File("dest.text");
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file, true)));
        student s1 = new student("aa", 12);
        student s2 = new student("assss", 1111);
        oos.writeObject(s1);
        oos.writeObject(s2);
        oos.writeObject(new Date());
        oos.writeUTF("-----------dasdfhkajsfhjkashfkj");
        oos.flush();
        oos.close();
    }

    public static void main(String[] args) {
        try {
            output();
            input();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class student implements Serializable {
    private String name;
    private int age;

    public student() {
    }

    public student(String name, int age) {
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


//    public String toString() {
//        return "student{" + "name='" + name + '\'' + ", age=" + age + '}';
//    }

}