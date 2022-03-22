package com.test.demo.Service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.exceptionHandle.DepartmentNotFound;
import com.test.demo.exceptionHandle.DuplicateEmailAddress;
import com.test.demo.entity.Department;
import com.test.demo.Repository.DepartmentRepository;
import com.test.demo.departmentDTO.DepartmentDto;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	DepartmentRepository departmentRepo;
	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentdto) throws DuplicateEmailAddress {
		Department department=new Department();
		BeanUtils.copyProperties(departmentdto, department);
		Department department1=departmentRepo.findBydepartmentEmailAddress(department.getDepartmentEmailAddress());
		if (department1==null) {
			department1=departmentRepo.save(department);
		}
		else {
			throw new DuplicateEmailAddress("Duplicate Department");	
		}
		
		DepartmentDto dto= new DepartmentDto();
				BeanUtils.copyProperties(department1, dto);
	return dto;	 
	}

	@Override
	public List<Department> fetchDepartment() {
		
		return departmentRepo.findAll();
	}

	@Override
	public Department fetchDepartmentById(String id) throws DepartmentNotFound {
		// TODO Auto-generated method stub
		Department department =departmentRepo.findBydepartmentEmailAddress(id);
		if(department==null)
		{
			throw new DepartmentNotFound("NOT FOUND");
		}
		return department;
	}

	@Override
	public Department deleteDepartmentById(String id) throws DepartmentNotFound {
		// TODO Auto-generated method stub
		Department department= departmentRepo.deleteBydepartmentEmailAddress(id);
		if(department==null)
		{
			throw new DepartmentNotFound("not found");
		}
		return department;
	}

	@Override
	public Department updateDepartment(String id, Department department) {
		// TODO Auto-generated method stub
		Department department1=departmentRepo.findBydepartmentEmailAddress(id);
		if(department1!=null && department.getDepartmentEmailAddress()!=null)
		   department1.setDepartmentEmailAddress(department.getDepartmentEmailAddress());
		
		if(department1!=null && department.getDate()!=null)
			department1.setDate(department.getDate());
		return department1;
	}

	@Override
	public Department fetchDepartmentByDepartmentName(String name) {
		// TODO Auto-generated method stub
		Department department=departmentRepo.findBydepartmentName(name);
		return department;
	}

}
