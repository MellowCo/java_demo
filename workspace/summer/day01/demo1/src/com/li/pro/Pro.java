package com.li.pro;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Pro {
    List<Student> students = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

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
        Student student = new Student();

        try {
            System.out.println("请输入学号");
            int sno = checkInt();

            if (sno == -1) {
                System.out.println("请输入正确的字符");
                return;
            }


            for (Student student1 : students) {
                if (student1.getId() == sno) {
                    System.out.println("此学生已存在");
                    return;
                }
            }
            student.setId(sno);

            System.out.println("请输入姓名");
            student.setName(sc.next());

            System.out.println("请输入性别");
            student.setSex(sc.next());

            System.out.println("请输入年龄");
            int age = checkInt();

            if (age == -1) {
                System.out.println("请输入正确的字符");
                return;
            } else {
                student.setAge(age);
            }

            students.add(student);
            System.out.println("添加成功!!!");

        } catch (InputMismatchException e) {
            System.out.println("请输入正确的字符");
        }


    }

    public void updateStudent() {

        int index = selectById();

        if (index == -1) {
            System.out.println("没有找到该学生，请检查学号是否正确");
        } else if (index == -2) {
            System.out.println("请输入正确的字符");
            return;
        } else {
            Student student = students.get(index);
            System.out.println("请输入姓名");
            student.setName(sc.next());

            System.out.println("请输入性别");
            student.setSex(sc.next());

            System.out.println("请输入年龄");

            int age = checkInt();
            if (age == -1) {
                System.out.println("请输入正确的字符");
                return;
            } else {
                student.setAge(age);
            }


            students.set(index, student);
            System.out.println("修改成功！");
        }
    }

    public int selectById() {
        System.out.println("请输入学号");
        int index = -1;
        int id = checkInt();

        if (id == -1) {
            return -2;
        }

        for (Student student : students) {
            index++;
            if (student.getId() == id) {
                return index;
            }
        }
        return -1;
    }

    public void queryStudent() {
        int index = selectById();

        if (index == -1) {
            System.out.println("没有找到该学生，请检查学号是否正确");

        } else if (index == -2) {
            System.out.println("请输入正确的字符");
        } else {
            System.out.println(students.get(index));
        }
    }

    public void queryStudents() {
        if (students.isEmpty()) {
            System.out.println("无学生录入");
        } else {
            System.out.println(students);
        }
    }

    public void deleteStudent() {
        int index = selectById();

        if (index == -1) {
            System.out.println("没有找到该学生，请检查学号是否正确");
        } else if (index == -2) {
            System.out.println("请输入正确的字符");
        } else {
            students.remove(index);
            System.out.println("删除成功");
        }
    }

    public int checkInt() {
        String s = sc.next();

        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        new Pro().getNum();
    }

}
