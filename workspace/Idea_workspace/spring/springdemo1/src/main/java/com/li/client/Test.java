package com.li.client;

import com.li.dao.impl.UserDaoImpl;
import com.li.factory.BeanFactory;
import com.li.service.IUserService;
import com.li.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        // IUserService ius = new UserServiceImpl();
        // IUserService ius = (IUserService)BeanFactory.getBean("userservice");
        // ius.saveUser();

        //spring 获取核心容器
        // ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new FileSystemXmlApplicationContext("I:\\Java\\workspace\\Idea_workspace\\spring\\springdemo1\\src\\main\\resources\\bean.xml");

        //根据id 获取bean对象
        UserDaoImpl bean = (UserDaoImpl)ac.getBean("userDao");
        UserDaoImpl user = ac.getBean("userDao",UserDaoImpl.class);

        bean.saveUser();
        user.saveUser();
    }
}
