package com.li.springboot.mapper;

import com.li.springboot.daomain.User;

import java.util.List;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-07 17:45
 */
// @Mapper
public interface UserMapper {

    // @Select("select * from user")
    List<User> all();

    // @Insert("insert into user values(null,#{name})")
    //获取自增的主键
    // @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    Integer insert(User user);

    // @Delete("delete from user where id = #{id}")
    Integer del(Integer id);

    // @Update("update user set name = #{name} where id = #{id}")
    Integer update(User user);

}
