package com.li.test;

import com.li.entiey.Account;
import com.li.service.IAccountService;
import config.BeanConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanConfig.class)
public class DaoTest {
    @Autowired
    IAccountService dao = null;

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
