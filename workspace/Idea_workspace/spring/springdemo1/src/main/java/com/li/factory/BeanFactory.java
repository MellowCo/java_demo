package com.li.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {
    private static Properties pros;

    static {
        pros = new Properties();
        //读取配置信息
        InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("user.properties");
        try {
            pros.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String key){
        Object o = null;
        try {
            //通过反射创建对象
             o = Class.forName(pros.getProperty(key)).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return o;
    }

}
