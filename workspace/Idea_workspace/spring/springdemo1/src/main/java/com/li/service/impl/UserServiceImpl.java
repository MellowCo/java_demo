package com.li.service.impl;

import com.li.dao.IUserDao;
import com.li.factory.BeanFactory;
import com.li.service.IUserService;

public class UserServiceImpl implements IUserService {
    // IUserDao iud = new UserDaoImpl();
    IUserDao iud = (IUserDao) BeanFactory.getBean("userdao");

    public void saveUser() {
        iud.saveUser();
    }
}
