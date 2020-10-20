package com.li.dao.impl;

import com.li.dao.IUserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {

    public UserDaoImpl(String name) {
    }

    public UserDaoImpl() {
    }

    public void saveUser() {
        System.out.println("保存成功");
    }
}
