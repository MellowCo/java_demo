package com.li.springboot.cache.services;

import com.li.springboot.cache.domain.Employee;
import com.li.springboot.cache.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-09 10:55
 */
@Service
public class EmpServices {

    @Autowired
    private EmpMapper empMapper;

    // 当id==2，缓存
    // @Cacheable(cacheNames="emp",key = "#id",condition = "#id == 2")
    //当id ！= 2，缓存
    // @Cacheable(cacheNames="emp",key = "#id",unless = "#id == 2")
    //自定义KeyGenerator
    @Cacheable(cacheNames = "emp"/**,keyGenerator = "myKey",unless = "#id == 2"*/)
    public Employee getById(Integer id) {
        System.out.println("getId");
        Employee employee = empMapper.getById(id);
        return employee;
    }

    @Cacheable(cacheNames = "emps")
    public Employee getByIds(Integer id) {
        System.out.println("getId");
        Employee employee = empMapper.getById(id);
        return employee;
    }

    @CacheEvict(cacheNames = "emp", key = "#id")
    public void delEmp(Integer id) {
        System.out.println("del" + id);
    }


    @CachePut(cacheNames = "emp",key = "#employee.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("updeta");
        empMapper.update(employee);
        return employee;
    }
}
