package com.li.springboot.cache.mapper;

import com.li.springboot.cache.domain.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-09 10:46
 */
@Mapper
public interface EmpMapper {

    @Select("select * from employee")
    List<Employee> getAll();

    @Select("select * from employee where id=#{id}")
    Employee getById(Integer id);

    @Insert("insert into employee values(null,#{lastName},#{email},#{gender},#{dId})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Integer insert(Employee employee);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    Integer update(Employee employee);

    @Delete("delete from employee where id=#{id}")
    Integer delById(Integer id);

}
