package com.li.dao;

import com.li.entiey.Account;

import java.util.List;

public interface IAccountDao {

    List<Account> findAll();

    Account findByID(int id);

    void addAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(int id);
}
