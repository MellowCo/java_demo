package com.li.day4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {

    public static void sameChar() {
        String s = "avcavcaabba";

        Map<Character, Integer> chars = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!chars.containsKey(s.charAt(i))) {
                chars.put(s.charAt(i), 1);
            } else {
                chars.put(s.charAt(i), chars.get(s.charAt(i)) + 1);
            }
        }

        System.out.println(chars);
    }





    public static void main(String[] args) {
        sameChar();
    }

}
