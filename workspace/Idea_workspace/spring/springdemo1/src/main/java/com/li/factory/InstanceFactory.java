package com.li.factory;

import com.li.dao.impl.UserDaoImpl;

public class InstanceFactory {

    public UserDaoImpl getUserDaoImpl(){
        return new UserDaoImpl();
    }
}
