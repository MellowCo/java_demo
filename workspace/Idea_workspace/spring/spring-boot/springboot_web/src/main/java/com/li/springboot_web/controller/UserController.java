package com.li.springboot_web.controller;

import com.li.springboot_web.dao.DepartmentDao;
import com.li.springboot_web.dao.EmployeeDao;
import com.li.springboot_web.entities.Department;
import com.li.springboot_web.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-08-31 16:46
 */
@Controller
public class UserController {
    @Autowired
    EmployeeDao dao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/user/logincheck")
    public String login(String username, String pwd, Map<String,Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username) && "111".equals(pwd)) {
            session.setAttribute("username",username);
            return "redirect:/main.html";
        }else{
            map.put("msg", "用户名密码错误！");
            return "login";
        }
    }

    @GetMapping("/emps")
    public String list(Model model){
        model.addAttribute("emps", dao.getAll());
        return "list";
    }

    /*
     * 来到添加用户的页面
     */
    @GetMapping("/emp")
    public String toAddEmp(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps", departments);
        return "add";
    }

    /*
     * 添加员工
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        dao.save(employee);
        System.out.println(employee);
        return "redirect:/emps";
    }

    /*
     * 获取修改员工的信息
     */
    @GetMapping("/emp/{id}")
    public String getOne(@PathVariable("id") Integer id,Model model){
        model.addAttribute("emp", dao.get(id));

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps", departments);
        return "add";
    }

    /*
     * 修改信息
     */
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        dao.save(employee);
        return "redirect:/emps";
    }

    /*
     * 删除员工
     */
    @DeleteMapping("/emp/{id}")
    public String del(@PathVariable("id") Integer id){
        dao.delete(id);
        return "redirect:/emps";
    }
}
