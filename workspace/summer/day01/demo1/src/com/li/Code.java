package com.li;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Code {
     List<Object> code = new ArrayList<>();

    public Code() {
        //在构造函数中调用init方法
        init();
    }

    //向集合中添加0-9 a-z A-Z
    public void init() {
        //添加0~9
        for (int i = 0; i < 10; i++) {
            code.add(i);
        }

        //添加大小写字母
        for (int i = 0; i < 26; i++) {
            code.add(String.valueOf((char) (65 + i)));
            code.add(String.valueOf((char) (97 + i)));
        }
    }


    //生成随机码
    void randomCode() {
        //生成十组
        for (int i = 0; i < 10; i++) {
            StringBuilder sb = new StringBuilder();

            sb.append("随机验证码:");
            //生成6个0~62的随机数
            //通过随机数，从集合中得到相应的字符
            for (int j = 0; j < 6; j++) {
                sb.append(code.get(new Random().nextInt(code.size())));
            }
            //将验证码输出
            System.out.println(sb.toString());
        }
    }


    public static void main(String[] args) {
        new Code().randomCode();
    }

}
