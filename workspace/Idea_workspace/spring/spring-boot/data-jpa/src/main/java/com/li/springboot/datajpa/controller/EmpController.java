package com.li.springboot.datajpa.controller;

import com.li.springboot.datajpa.domain.Emp;
import com.li.springboot.datajpa.repository.EmpRe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-08 10:30
 */
@RestController
public class EmpController {

    @Autowired
    EmpRe repository;

    /*
     * 查询所有
     */
    @GetMapping("/emps")
    public List<Emp> all(){
        return repository.findAll();
    }

    @PostMapping("/emp")
    public Emp insert(Emp emp){
        return repository.save(emp);
    }

}
