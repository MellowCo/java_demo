package com.li.mapper;

import com.li.domain.User;

import java.util.List;

/**
 * @Program: mybatis_manyToMany
 * @ClassName: UserDao
 * @Description:
 * @Author: li
 * @Create: 2019-08-19 12:45
 */
public interface UserDao {

    List<User> findAll();

    List<User> findUserRole();

    User findById(Integer id);
}
