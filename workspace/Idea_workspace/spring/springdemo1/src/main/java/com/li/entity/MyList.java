package com.li.entity;

import java.util.*;

public class MyList {
    private int[] myArray;
    private List<String> myList;
    private Set<String> mySet;

    private Map<String,String> myMap;
    private Properties pros;

    public void setMyArray(int[] myArray) {
        this.myArray = myArray;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setPros(Properties pros) {
        this.pros = pros;
    }

    public void toSava() {
        System.out.println( "MyList{" +
                "myArray=" + Arrays.toString(myArray) +
                ", myList=" + myList +
                ", mySet=" + mySet +
                ", myMap=" + myMap +
                ", pros=" + pros +
                '}');
    }
}
