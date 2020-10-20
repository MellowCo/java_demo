package com.li.dao;

import com.li.entity.User;

import java.util.List;
import java.util.Map;

public interface IUserDao {
   /**
    *功能描述 查询所有学生
    * @author li
    * @date 2019/7/17
    * @param
    * @return java.util.List<com.li.entity.User>
    */
   List<User> queryAllUser();

   /**
    *功能描述 添加用户
    * @author li
    * @date 2019/7/16
    * @param User
    * @return void
    */
    void addUser(User user);

    /**
     *功能描述 根据学号查询学生
     * @author li
     * @date 2019/7/17
     * @param id
     * @return com.li.entity.User
     */
    User queryUserById(int id);

    /**
     *功能描述 更改用户信息
     * @author li
     * @date 2019/7/17
     * @param user
     * @return void
     */
    void updateUser(User user);

    /**
     *功能描述 根据id 删除用户
     * @author li
     * @date 2019/7/17
     * @param id
     * @return void
     */
    void delUserById(int id);

    /**
     *功能描述 返回用户总数
     * @author li
     * @date 2019/7/17
     * @param
     * @return int
     */
    int totalUser();

    /**
     *功能描述 分页显示用户
     * @author li
     * @date 2019/7/17
     * @param currentPage 起始数据
     * @param pageSize  页面大小
     * @return java.util.List<com.li.entity.User>
     */
    List<User> pageUser(int currentPage, int pageSize, Map<String, String[]> map);

    /**
     *功能描述 模糊查询,返回数据总数
     * @author li
     * @date 2019/7/19
     * @param map
     * @return int
     */
    int totalUser(Map<String, String[]> map);

    /**
     *功能描述 返回模糊查询，分页，所需要的sql语句和sql语句所要的参数
     * @author li
     * @date 2019/7/19
     * @param sql
     * @param map
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    Map<String,Object> pageSql(StringBuilder sql,Map<String, String[]> map);

}
