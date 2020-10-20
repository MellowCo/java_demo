package com.li.springboot.security.mapper;

import com.li.springboot.security.damain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-16 10:13
 */
@Mapper
public interface UserMapper {
    /*
     * 根据用户名查用户
     */
    public User queryByName(String name);

    /*
     * 根据用户名查权限
     */
    public List<String> queryRoleByName(String name);
}
