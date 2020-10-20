package com.li.day4;

import java.util.*;

public class Poker {
    Map<String, Integer> pokers = new HashMap<>();
    List<String> keys = new ArrayList<>();

    public Poker() {
        init();
    }

    public void init() {
        pokers.put("2", 4);
        pokers.put("3", 4);
        pokers.put("4", 4);
        pokers.put("5", 4);
        pokers.put("6", 4);
        pokers.put("7", 4);
        pokers.put("8", 4);
        pokers.put("9", 4);
        pokers.put("10", 4);
        pokers.put("J", 4);
        pokers.put("Q", 4);
        pokers.put("K", 4);
        pokers.put("A", 4);
        pokers.put("大王", 1);
        pokers.put("小王", 1);

        Collections.addAll(keys,"2","3","4","5","6","7","8","9","10","J","Q","K","A","大王","小王");
    }

    void getPoker(Map<String, Integer> map) {
        boolean flag = true;

        while (flag) {
            int i = new Random().nextInt(15);
            String key = keys.get(i);

            if (pokers.get(key) == 0) {
                continue;
            } else if (!map.containsKey(key)) {
                map.put(key, 1);
                pokers.put(key, pokers.get(key) - 1);
                break;
            } else {
                map.put(key, map.get(key) + 1);
                pokers.put(key, pokers.get(key) - 1);
                break;
            }
        }
    }

    void start() {
        Map<String, Integer> p1 = new TreeMap<>();
        Map<String, Integer> p2 = new HashMap<>();
        Map<String, Integer> p3 = new HashMap<>();

        for (int i = 0; i < 17; i++) {
            getPoker(p1);
            getPoker(p2);
            getPoker(p3);
        }
        System.out.println("p1->" + p1);
        System.out.println("p2->" + p2);
        System.out.println("p3->" + p3);

        Set<String> sets = pokers.keySet();
        System.out.print("底牌:");
        for (String set : sets) {
            if (pokers.get(set) > 0) {
                System.out.print(set + "=" + pokers.get(set) + " ");
            }
        }
    }

    public static void main(String[] args) {
        new Poker().start();
    }

}
