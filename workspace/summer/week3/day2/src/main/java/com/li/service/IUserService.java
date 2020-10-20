package com.li.service;

import com.li.entity.User;

import java.util.List;
import java.util.Map;

public interface IUserService {
    /**
     *功能描述 查询所有用户
     * @author li
     * @date 2019/7/17
     * @param
     * @return List<User>
     */
    List<User> queryAllUser();

    /**
     *功能描述 根据学号查询学生
     * @author li
     * @date 2019/7/17
     * @param id
     * @return com.li.entity.User
     */
    User queryUserById(int id);

    /**
     *功能描述 实现注册
     * @author li
     * @date 2019/7/16
     * @param User
     * @return void
     */
    void register(User user);

    /**
     *功能描述 更改用户信息
     * @author li
     * @date 2019/7/17
     * @param user
     * @return void
     */
    void update(User user);

    /**
     *功能描述 根据id 删除用户
     * @author li
     * @date 2019/7/17
     * @param id
     * @return void
     */
    void delUserById(int id);

    /**
     *功能描述 分页显示用户
     * @author li
     * @date 2019/7/17
     * @param currentPage 起始数据
     * @param pageSize  页面大小
     * @return java.util.List<com.li.entity.User>
     */
    List<User> pageUser(int currentPage, int pageSize, Map<String, String[]> map);
}
