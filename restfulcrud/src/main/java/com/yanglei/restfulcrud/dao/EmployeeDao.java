package com.yanglei.restfulcrud.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.yanglei.restfulcrud.entity.Department;
import com.yanglei.restfulcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDao {

	private static Map<Integer, Employee> employees = null;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	static{
		employees = new HashMap<Integer, Employee>();

		employees.put(1001, new Employee(1001, "Jack", "jack@email.com", 1, new Department(101, "Company-A")));
		employees.put(1002, new Employee(1002, "John", "john@email.com", 1, new Department(102, "Company-B")));
		employees.put(1003, new Employee(1003, "Lucy", "lucy@email.com", 0, new Department(103, "Company-C")));
		employees.put(1004, new Employee(1004, "Linda", "linda@email.com", 0, new Department(104, "Company-D")));
		employees.put(1005, new Employee(1005, "Smith", "smith@email.com", 1, new Department(105, "Company-E")));
	}
	
	private static Integer initId = 1006;
	
	public void save(Employee employee){
		if(employee.getId() == null){
			employee.setId(initId++);
		}
		
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}
	
	public Collection<Employee> getAll(){
		return employees.values();
	}
	
	public Employee get(Integer id){
		return employees.get(id);
	}
	
	public void delete(Integer id){
		employees.remove(id);
	}
}
