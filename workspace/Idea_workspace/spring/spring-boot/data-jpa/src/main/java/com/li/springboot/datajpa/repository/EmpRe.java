package com.li.springboot.datajpa.repository;

import com.li.springboot.datajpa.domain.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-08 10:27
 */
//继承JpaRepository来完成对数据库的操作
public interface EmpRe extends JpaRepository<Emp,Integer> {
}
