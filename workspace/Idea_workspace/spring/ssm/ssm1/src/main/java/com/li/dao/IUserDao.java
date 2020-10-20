package com.li.dao;

import com.li.damain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Program: ssm1
 * @ClassName: IUserDao.xml
 * @Description:
 * @Author: li
 * @Create: 2019-08-04 15:03
 */

@Repository("userDao")
public interface IUserDao {

    /**
     * @Description: 查询所有学生
     * @Author: li
     * @Create: 2019/8/4-15:03
     * @param
     * @Return java.util.List<com.li.damain.User>
     */
    List<User> findAll();

    /**
     * @Description: 添加一个学生
     * @Author: li
     * @Create: 2019/8/4-15:04
     * @param user
     * @Return void
     */
    void addUser(User user);

    void updateUser(User user);
}
