package com.li.client;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-11-23 15:53
 */
public class Sort {

    public static int[] sort(int[] arr){
        int tmp;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]>arr[j]){
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }


        return arr;
    }


    public static void main(String[] args) {
        int[] arr ={1,32,44,2,43,55,66,22,99,3,4,2,5};

        int[] test = sort(arr);
        for (int i : test) {
            System.out.println(i);
        }
    }
}
