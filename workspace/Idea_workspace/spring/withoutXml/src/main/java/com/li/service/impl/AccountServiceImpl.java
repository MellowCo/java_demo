package com.li.service.impl;

import com.li.dao.IAccountDao;
import com.li.entiey.Account;
import com.li.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao dao;

    @Override
    public List<Account> findAll() {
        return dao.findAll();
    }

    @Override
    public Account findByID(int id) {
        return dao.findByID(id);
    }

    @Override
    public void addAccount(Account account) {
        dao.addAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        dao.updateAccount(account);
    }

    @Override
    public void deleteAccount(int id) {
        dao.deleteAccount(id);
    }
}
