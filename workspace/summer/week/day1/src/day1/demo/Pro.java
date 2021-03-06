package day1.demo;

import java.util.List;
import java.util.Scanner;

public class Pro {
    Scanner sc = new Scanner(System.in);
    StudentDao sd = new StudentDao();

    public void print() {
        System.out.println("****  学生管理系统     ****");
        System.out.println("****  1:增加学生      ****");
        System.out.println("****  2:修改学生信息   ****");
        System.out.println("****  3:按学号查看学生 ****");
        System.out.println("****  4:查看所有学生   ****");
        System.out.println("****  5:删除学生      ****");
        System.out.println("****  6:退出         ****");
        System.out.println("****  请输入数字       ****");
        System.out.println("*************************");
    }


    public void getNum() {
        boolean flag = true;
        while (flag) {
            print();
            String i = sc.next();

            switch (i) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    updateStudent();
                    break;
                case "3":
                    queryStudent();
                    break;
                case "4":
                    queryStudents();
                    break;
                case "5":
                    deleteStudent();
                    break;
                case "6":
                    flag = false;
                    System.out.println("退出成功！");
                    break;
                default:
                    System.out.println("请输入正确的数字");
                    break;
            }
        }
        sc.close();
    }

    public void addStudent() {
        System.out.println("请输入学号");
        int id = sc.nextInt();

        if (sd.queryStudentById(id) != null) {
            System.out.println("该学号被占用");
            return;
        }

        Student student = new Student();
        student.setId(id);

        System.out.println("请输入姓名");
        student.setName(sc.next());

        System.out.println("请输入性别");
        student.setSex(sc.next());

        System.out.println("请输入年龄");
        student.setAge(sc.nextInt());

        sd.addStudent(student);
        System.out.println("添加成功!!!");
    }

    public void updateStudent() {
        System.out.println("请输入更改的学号");

        Student student = sd.queryStudentById(sc.nextInt());
        if (student == null) {
            System.out.println("没有找到该学生，请检查学号是否正确");
        } else {
            System.out.println("请输入姓名");
            student.setName(sc.next());

            System.out.println("请输入性别");
            student.setSex(sc.next());

            System.out.println("请输入年龄");

            student.setAge(sc.nextInt());

            sd.updateStudentById(student);
            System.out.println("修改成功！");
        }

    }


    public void queryStudent() {
        System.out.println("请输入学号");
        Student student = sd.queryStudentById(sc.nextInt());

        if (student == null) {
            System.out.println("没有找到该学生，请检查学号是否正确");

        } else {
            System.out.println(student);
        }
    }

    public void queryStudents() {
        List<Student> students = sd.queryStudents();

        if (students.isEmpty()) {
            System.out.println("无学生录入");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void deleteStudent() {
        System.out.println("请输入删除的学号");
        Student student = sd.queryStudentById(sc.nextInt());

        if (student == null) {
            System.out.println("该学生不存在");
        } else {
            sd.deleteStudentById(student.getId());
            System.out.println("删除成功");
        }
    }

    public static void main(String[] args) {
        new Pro().getNum();
    }

}
