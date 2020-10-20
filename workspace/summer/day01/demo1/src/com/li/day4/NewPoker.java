package com.li.day4;

import java.util.*;

public class NewPoker {
    public static void main(String[] args) {
        Map<Integer, String> pokers = new HashMap<>();
        List<String> color = new ArrayList<>();
        List<String> num = new ArrayList<>();
        Collections.addAll(color, "梅花", "方片", "黑桃", "红桃");
        Collections.addAll(num, "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");

        int count = 1;
        pokers.put(count++, "小王");
        pokers.put(count++, "大王");
        for (String s : num) {
            for (String s1 : color) {
                pokers.put(count++, s1 + s);
            }
        }


        List<Integer> random = new ArrayList<>();
        for (int i = 1; i < 55; i++) {
            random.add(i);
        }

        Collections.shuffle(random);

        List<Integer> p1 = new ArrayList<>();
        List<Integer> p2 = new ArrayList<>();
        List<Integer> p3 = new ArrayList<>();
        List<Integer> di = new ArrayList<>();


        int pos = 0;
        for (int i = 0; i < 17; i++) {
            p1.add(random.get(pos++));
            p2.add(random.get(pos++));
            p3.add(random.get(pos++));
        }

        di.add(random.get(51));
        di.add(random.get(52));
        di.add(random.get(53));

        Collections.sort(p1);
        Collections.sort(p2);
        Collections.sort(p3);
        Collections.sort(di);


        List<String> p11 = new ArrayList<>();
        List<String> p21 = new ArrayList<>();
        List<String> p31 = new ArrayList<>();
        List<String> di1 = new ArrayList<>();

        for (int i = 0; i < 17; i++) {
            p11.add(pokers.get(p1.get(i)));
            p21.add(pokers.get(p2.get(i)));
            p31.add(pokers.get(p3.get(i)));
        }

        di1.add(pokers.get(p3.get(0)));
        di1.add(pokers.get(p3.get(1)));
        di1.add(pokers.get(p3.get(2)));

        System.out.println(p11);
        System.out.println(p21);
        System.out.println(p31);
        System.out.println(di1);
    }
}
