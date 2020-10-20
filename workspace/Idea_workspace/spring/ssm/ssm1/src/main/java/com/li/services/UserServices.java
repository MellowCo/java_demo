package com.li.services;

import com.li.damain.User;
import com.li.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Program: ssm1
 * @ClassName: UserServices
 * @Description:
 * @Author: li
 * @Create: 2019-08-04 15:33
 */

@Service("userServices")

public class UserServices {
    @Autowired
    private IUserDao dao;

    public List<User> findAll(){
        return dao.findAll();
    }

    public void addUser(User user){
        dao.addUser(user);
    }

    public void update(User user){
        dao.updateUser(user);
        int i = 1/0;
    }

}
