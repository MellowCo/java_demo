package com.li;

import java.util.*;

public class SetTest {

    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();

        while (s.size() < 10) {
            s.add(new Random().nextInt(20) + 1);
        }

        // System.out.println(s);
        // repeat();
        //*aaaaaaaaabbbbbbbbbcccddddddd
        List<String> lists = new ArrayList<>();
        lists.add("a");
        lists.add("a");
        lists.add("a");
        lists.add("b");
        lists.add("c");
        lists.add("c");
        lists.add("b");

        System.out.println("旧的集合:" + lists);
        System.out.println("新的集合:" + listRepleat(lists));

        // sort(lists);
        // print();
        // printNum();
        // grade();
    }



    //将集合中的重复元素去除
    private static List<String> listRepleat(List<String> lists) {
        //通过set去重
        Set<String> sets = new HashSet<>();

        //循环遍历lists，将元素添加到sets中
        for (String list : lists) {
            sets.add(list);
        }

        List<String> newlist = new ArrayList<>();
        //将去重的元素添加到新的集合中，并返回
        for (String set : sets) {
            newlist.add(set);
        }

        return newlist;

    }

    //使用Scanner从键盘中读取一行输入，取出其中的重复字符
    private static void repeat() {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        Set<String> sets = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            sets.add(String.valueOf(s.charAt(i)));
        }

        System.out.println(sets);
        sc.close();
    }

    //3 将集合中有序，字典排序
    private static void sort(List<String> strings) {
        Set<String> sets = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.charAt(0) > o2.charAt(0) ? 1 : -1;
            }
        });

        for (String string : strings) {
            sets.add(string);
        }

        System.out.println(sets);
    }

    //4 键盘输入，有序输出
    private static void print() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Set<Character> chars = new TreeSet<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1 > o2 ? 1 : -1;
            }
        });

        for (int i = 0; i < s.length(); i++) {
            chars.add(s.charAt(i));
        }

        System.out.println(chars);
        sc.close();
    }

    //5 键盘输入数字，倒序输出
    private static void printNum() {
        Scanner sc = new Scanner(System.in);
        Set<Integer> ints = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        });

        String s = null;
        while (!(s = sc.nextLine()).equals("quit")) {
            ints.add(Integer.parseInt(s));
        }

        System.out.println(ints);
        sc.close();
    }

    private static void grade() {
        Scanner sc = new Scanner(System.in);
        Set<Student> students = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {

                return o1.getSum() < o2.getSum() ? 1 : -1;
            }
        });

        while (students.size() < 5){
            Student s = new Student();
            System.out.println("请输入姓名");
            s.setName(sc.next());
            System.out.println("输入语文成绩");
            s.setChinese(sc.nextInt());
            System.out.println("输入数学成绩");
            s.setMath(sc.nextInt());
            System.out.println("输入英语成绩");
            s.setEng(sc.nextInt());
            s.sum();
            students.add(s);
        }

        for (Student student : students) {
            System.out.println(student);
        }

    }
}


class Student {
    private String name;
    private int chinese;
    private int math;
    private int eng;
    private int sum;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return chinese;
    }
    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", chinese=" + chinese +
                ", math=" + math +
                ", eng=" + eng +
                ", sum=" + sum +
                '}';
    }

    public void sum() {
        sum = chinese + math + eng;
    }
}