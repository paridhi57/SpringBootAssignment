package com.test.demo.Service;

import java.util.List;


import com.test.demo.exceptionHandle.DepartmentNotFound;
import com.test.demo.exceptionHandle.DuplicateEmailAddress;
import com.test.demo.departmentDTO.DepartmentDto;
import com.test.demo.entity.Department;

public interface DepartmentService {
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) throws DuplicateEmailAddress;
		
		public List<Department> fetchDepartment();

		
		public Department fetchDepartmentById(String id) throws DepartmentNotFound;
		
		public Department deleteDepartmentById(String id) throws DepartmentNotFound;

		public Department updateDepartment(String id,Department department);
		public Department fetchDepartmentByDepartmentName(String name);
}
