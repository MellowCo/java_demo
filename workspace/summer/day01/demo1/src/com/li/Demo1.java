package com.li;


import java.util.Arrays;

public class Demo1 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};

        System.out.print("[");

        for (int j = 0; j < a.length; j++) {

            if (j == a.length - 1) {
                System.out.print(a[j]);
            } else {
                System.out.print(a[j] + ",");
            }
        }
        Arrays.toString(a);

        System.out.println("]");

    }

}
