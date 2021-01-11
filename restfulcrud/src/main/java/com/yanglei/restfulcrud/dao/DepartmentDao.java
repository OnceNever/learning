package com.yanglei.restfulcrud.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.yanglei.restfulcrud.entity.Department;
import org.springframework.stereotype.Repository;


@Repository
public class DepartmentDao {

	private static Map<Integer, Department> departments = null;
	
	static{
		departments = new HashMap<Integer, Department>();
		
		departments.put(101, new Department(101, "Company-A"));
		departments.put(102, new Department(102, "Company-B"));
		departments.put(103, new Department(103, "Company-C"));
		departments.put(104, new Department(104, "Company-D"));
		departments.put(105, new Department(105, "Company-E"));
	}
	
	public Collection<Department> getDepartments(){
		return departments.values();
	}
	
	public Department getDepartment(Integer id){
		return departments.get(id);
	}
	
}
