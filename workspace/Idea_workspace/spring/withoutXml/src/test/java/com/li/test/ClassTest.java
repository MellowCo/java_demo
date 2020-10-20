package com.li.test;

import com.li.entiey.Account;
import com.li.service.impl.AccountServiceImpl;
import config.BeanConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ClassTest {
    ApplicationContext ac = null;
    AccountServiceImpl dao = null;

    @Before
    public void init() {
        ac = new AnnotationConfigApplicationContext(BeanConfig.class);
        dao = ac.getBean("accountService", AccountServiceImpl.class);
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = dao.findAll();
        System.out.println(accounts);
    }

    @Test
    public void testAdd() {
        Account account = new Account(4, "hao", 333);
        dao.addAccount(account);
    }

    @Test
    public void testUpdate() {
        Account account = new Account();
        account.setId(4);
        account.setName("xiao");
        account.setMoney(900);
        dao.updateAccount(account);
    }

    @Test
    public void testFindByID() {
        System.out.println(dao.findByID(1));
    }

    @Test
    public void testDelete(){
        dao.deleteAccount(4);
    }
}
