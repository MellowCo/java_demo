package com.li;

import java.util.*;

public class FindIndexTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        Set<String> strings = new HashSet<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list);
        System.out.println(findIndex(list,6));

        replaceList(list,6,8);
        System.out.println(list);

    }



    private static int findIndex(List<Integer> list,int i1){
        int index = -1;

        for(int i =0;i<list.size();i++){
            if(i1 == list.get(i)){
                index = i;
                break;
            }
        }
        return index;
    }

    private static void replaceList(List<Integer> list,int oldv,int nevw){
        for(int i =0 ;i<list.size();i++){
            if(list.get(i) == oldv){
                list.set(i,nevw);
            }
        }
    }


}
