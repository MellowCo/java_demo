package com.li;

import java.util.*;

public class Demo3 {

    static void getWH() {
        List<Integer> heights = new ArrayList<>();
        List<Integer> widths = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("请输入身高");
            heights.add(sc.nextInt());
            System.out.println("请输入体重");
            widths.add(sc.nextInt());
        }
        sc.close();
        Map<String, Integer> aver = getAverage(heights, widths);
        getResult(aver);
    }

    static Map<String,Integer> getAverage(List<Integer> heights, List<Integer> widths){
        Map<String, Integer> aver = new HashMap<>();
        int sumH = 0;
        int sumW = 0;
        for (Integer height : heights) {
            sumH += height;
        }

        for (Integer width : widths) {
            sumW += width;
        }

        aver.put("averH",sumH/heights.size());
        aver.put("averW",sumW/widths.size());

        return aver;
    }

    static void getResult(Map<String,Integer> result){
        int averH = result.get("averH");
        int averW = result.get("averW");
        System.out.println(result);

        if(averH > 160 && averW < 60){
            System.out.println("合格");
        }else{
            System.out.println("不合格");
        }
    }



    public static void main(String[] args) {
        getWH();
    }
}
