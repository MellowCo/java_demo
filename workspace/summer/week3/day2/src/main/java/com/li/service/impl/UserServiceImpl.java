package com.li.service.impl;

import com.li.dao.IUserDao;
import com.li.dao.impl.UserDaoImpl;
import com.li.entity.User;
import com.li.service.IUserService;

import java.util.List;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @ClassName UserServiceImpl
 * @date 2019/7/16 14:39
 */
public class UserServiceImpl implements IUserService {
    private IUserDao dao = new UserDaoImpl();

    @Override
    public List<User> queryAllUser() {
        return dao.queryAllUser();
    }

    @Override
    public User queryUserById(int id) {
        return dao.queryUserById(id);

    }

    @Override
    public void register(User user) {
        dao.addUser(user);
    }

    @Override
    public void update(User user) {
        dao.updateUser(user);
    }

    @Override
    public void delUserById(int id) {
        dao.delUserById(id);
    }

    @Override
    public List<User> pageUser(int currentPage, int pageSize, Map<String, String[]> map) {
        return dao.pageUser(currentPage, pageSize, map);
    }

}
