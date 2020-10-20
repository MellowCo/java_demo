package com.li.mapper;

import com.li.domain.Account;

import java.util.List;

/**
 * @Program: mybatis_manyToMany
 * @ClassName: AccountDao
 * @Description:
 * @Author: li
 * @Create: 2019-08-19 13:05
 */
public interface AccountDao {

    List<Account> findAll();

    List<Account> findByUid(Integer uid);
}
