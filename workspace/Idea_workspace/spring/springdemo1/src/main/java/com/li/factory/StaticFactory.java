package com.li.factory;

import com.li.dao.impl.UserDaoImpl;

public class StaticFactory {
    public static UserDaoImpl getUserDao(){
        return new UserDaoImpl();
    }
}
