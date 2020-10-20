package test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class reg {
    public static void main(String[] args) {
//        String regex = "^[0-9]*$";
//        String regex = "\\b[0-9]*\\b";
        String regex = "[0-9]+";
        String source = "00000000wqw00000000eqweqwe21312123123313213adsd6767ttyt"
               ;
        for (String str : getMatchers(regex,source)) {
            System.out.println(str);
        }
        System.out.println(getMatchers(regex,source));
           Integer.parseInt("3123");
    }

    static List<String> getMatchers(String regex, String source){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;

    }
}
