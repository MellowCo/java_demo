package com.li;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo2 {
    //1 取最大值，最小值，平均值
    static void getMaxMin(int[] array) {
        int max, min, count;
        max = min = count = array[0];

        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            } else if (min > array[i]) {
                min = array[i];
            }
            count += array[i];
        }
        System.out.println("max:" + max);
        System.out.println("min:" + min);
        System.out.println("average:" + (double) count / array.length);
    }

    //2 二维数组
    static void doubleArray(int[][] arrays) {
        int count = 0;
        int num = 0;

        //行
        for (int i = 0; i < arrays.length; i++) {
            //列
            for (int j = 0; j < arrays[i].length; j++) {
                count += arrays[i][j];
            }
            num += arrays[i].length;
        }

        System.out.println("二维数组共" + num + "个数，平均值为" + (double) count / num);
    }

    //3 冒泡排序
    static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int a = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (a > array[j]) {
                    a = array[j];
                    array[j] = array[i];
                    array[i] = a;
                }
            }
        }
        System.out.println("冒泡排序:" + Arrays.toString(array));
    }

    //说谎
    static void problem() {
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        List<Integer> three = new ArrayList<>();

        for (int i = 100; i < 1000; i++) {
            if (i % 8 == 0) {
                one.add(i);
                if (i % 7 == 0) {
                    two.add(i);
                    int sum = i % 10 + i / 10 % 10 + i / 100;
                    if (sum == 15) {
                        three.add(i);
                    }
                }
            }
        }
        System.out.println("被2整除3次的有:" + one);
        System.out.println("被2整除3次,被7整除有:" + two);
        System.out.println("被2整除3次,被7整除,三位之和为15的有" + three);
    }

    //水仙花数
    static void water() {
        StringBuilder sb = new StringBuilder();
        sb.append("水仙花数有");

        for (int i = 100; i < 1000; i++) {
            int g = i % 10;
            int s = i / 10 % 10;
            int b = i / 100;

            int num = g * g * g + s * s * s + b * b * b;
            if (num == i) {
                sb.append(i + ",");
            }
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }


    public static void main(String[] args) {
        int[] array = {1, 4, 5, 2, 6, 7, 3, 7, 1, 0, 8};
        getMaxMin(array);
        bubbleSort(array);

        int[][] b = {
                {1, 1, 1, 1, 1, 1, 1, 1}, //8 1
                {3, 3, 3, 3, 3, 3},       //6 3
                {5, 5, 5, 5, 5}           //5 5   2.6
        };

        doubleArray(b);

        problem();
        water();
    }


}
