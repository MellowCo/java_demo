package com.li.test;

import com.li.dao.impl.UserDaoImpl;
import com.li.entity.MyList;
import com.li.entity.Person;
import com.li.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EntityTest {
    @Test
    public void UserTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        User user = ac.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void PersonTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        Person person = ac.getBean("person", Person.class);
        person.savePerson();
    }

    @Test
    public void ListTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        MyList myList = ac.getBean("myList", MyList.class);
        myList.toSava();
    }

    @Test
    public void daoTest(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        UserDaoImpl userDao = ac.getBean("userDao", UserDaoImpl.class);
        userDao.saveUser();
    }



}
