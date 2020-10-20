package com.li.springboot.cache.controller;

import com.li.springboot.cache.domain.Employee;
import com.li.springboot.cache.services.EmpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-09 10:57
 */
@RestController
public class EmpController {
    @Autowired
    private EmpServices empServices;

    // @GetMapping("/emps")
    // public List<Employee> getAll() {
    //     return empServices.getAll();
    // }

    @GetMapping("/emp/{id}")
    public Employee getById(@PathVariable("id") Integer id) {
        return empServices.getById(id);
    }

    @GetMapping("/emps/{id}")
    public Employee getByIds(@PathVariable("id") Integer id) {
        return empServices.getByIds(id);
    }


    @GetMapping("del/{id}")
    public String del(@PathVariable("id") Integer id) {
        empServices.delEmp(id);
        return "success";
    }

    @PostMapping("/emp")
    public Employee update(Employee employee){
        return empServices.updateEmp(employee);
    }
}
