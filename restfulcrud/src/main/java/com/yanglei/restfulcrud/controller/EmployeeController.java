package com.yanglei.restfulcrud.controller;

import com.yanglei.restfulcrud.dao.DepartmentDao;
import com.yanglei.restfulcrud.dao.EmployeeDao;
import com.yanglei.restfulcrud.entity.Department;
import com.yanglei.restfulcrud.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @ClassName: EmployeeController
 * @Description: TODO
 * @Author: Yanglei
 * @Date: 2020/7/11 12:34
 * @Version: V1.0
 */
@Controller
public class EmployeeController {
    Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeDao dao;

    @Autowired
    DepartmentDao departmentDao;
    /**查询所有员工列表返回页面
     * thymeleaf 默认就会拼串 classpath:/templates/xxx.html
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = dao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    /**
    * @Description TODO 员工添加页面
    * @Date 16:27 2020/7/11
    * @Param []
    * @return java.lang.String
    **/
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    /**
    * @Description TODO 员工添加 springMvc自动将请求参数和入参对象属性进行绑定，要求请求参数的名字要和javaBean对象里面的属性对应
    * @Date 16:55 2020/7/11
    * @Param [employee]
    * @return java.lang.String
    **/
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        dao.save(employee);
        log.info("添加的员工信息为："+employee);
        return "redirect:/emps";
    }

    /**
    * @Description TODO 来到修改员工信息页面，并加载已有信息
    * @Date 15:33 2020/7/12
    * @Param [id, model]
    * @return java.lang.String
    **/
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee emp = dao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("emp", emp);
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    /**
    * @Description TODO 修改员工信息
    * @Date 15:33 2020/7/12
    * @Param [employee]
    * @return java.lang.String
    **/
    @PutMapping("/emp")
    public String editEmployee(Employee employee){
        dao.save(employee);
        return "redirect:/emps";
    }

    /**
    * @Description TODO 根据id删除员工信息
    * @Date 15:36 2020/7/12
    * @Param [id]
    * @return java.lang.String
    **/
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        dao.delete(id);
        return "redirect:/emps";
    }
}
