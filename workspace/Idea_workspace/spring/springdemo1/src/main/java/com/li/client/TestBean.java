package com.li.client;

import com.li.dao.impl.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        UserDaoImpl userDao = ac.getBean("userDao", UserDaoImpl.class);
        UserDaoImpl userDao2 = ac.getBean("userDao", UserDaoImpl.class);

        userDao.saveUser();
        System.out.println(userDao == userDao2);
    }
}
