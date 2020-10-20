package com.li.day4;

import java.util.*;

public class Test {


    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Collections.addAll(nums, 1, 2, 3, 4, 5, 6);
        //
        // reverseList(nums);
        // football();
        deleteS();


        List<Integer> ones = new ArrayList<>();
        Collections.addAll(ones, 7, 8, 9, 10, 1, 2, 3);



        twoList(nums, ones);
    }

    private static void reverseList(List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            int oldNum = nums.get(i);
            for (int j = i + 1; j < nums.size(); j++) {
                int newNum = nums.get(j);
                if (oldNum < newNum) {
                    nums.set(i, newNum);
                    nums.set(j, oldNum);
                    oldNum = newNum;
                }
            }
        }

        System.out.println(nums);
    }

    public static void football() {
        List<Integer> foot = new ArrayList<>();

        for (int i = 1; i < 17; i++) {
            foot.add(i);
        }

        Collections.shuffle(foot);

        List<Integer> team1 = new ArrayList<>();
        List<Integer> team2 = new ArrayList<>();
        List<Integer> team3 = new ArrayList<>();
        List<Integer> team4 = new ArrayList<>();

        int pos = 0;
        for (int i = 0; i < 4; i++) {
            team1.add(foot.get(pos++));
            team2.add(foot.get(pos++));
            team3.add(foot.get(pos++));
            team4.add(foot.get(pos++));
        }

        System.out.println("team1:" + team1);
        System.out.println("team2:" + team2);
        System.out.println("team3:" + team3);
        System.out.println("team4:" + team4);
    }

    public static void deleteS() {
        String s = "sssstttdsdtsds";
        List<Character> chars = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != 's') {
                chars.add(c);
            }
        }

        System.out.println(chars);
    }

    public static void twoList(List<Integer> ones, List<Integer> twos) {
        Set<Integer> bing = new HashSet<>();
        Set<Integer> jiao = new HashSet<>();
        bing.addAll(ones);
        bing.addAll(twos);


        for (Integer one : ones) {
            for (Integer two : twos) {
                if (one == two) {
                    jiao.add(one);
                    break;
                }
            }
        }


        System.out.println("bing" + bing);
        System.out.println("jiao" + jiao);
    }


}
