package com.test.demo.Controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.exceptionHandle.DepartmentNotFound;
import com.test.demo.exceptionHandle.DuplicateEmailAddress;
import com.test.demo.Service.DepartmentService;
import com.test.demo.departmentDTO.DepartmentDto;
import com.test.demo.entity.Department;



@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService service;
	Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping(value="/departments", consumes= MediaType.APPLICATION_JSON_VALUE)
	public DepartmentDto saveDepartment(@Valid @RequestBody DepartmentDto departmentDto)
			throws DuplicateEmailAddress, IllegalAccessException, InvocationTargetException, NoSuchFieldException, SecurityException {
	//logger.info("St//////", departmentDto.getClass().getField("departmentName"));
		DepartmentDto dto = service.saveDepartment(departmentDto);
		return dto;
	}

	@GetMapping("/departments")
	public List<Department> fetchDepartment() {
		return service.fetchDepartment();
	}

	@GetMapping("/departments/{emailid}")
	public Department fetchDepartmentById(@PathVariable("emailid") String id) throws DepartmentNotFound {
		return service.fetchDepartmentById(id);
	}

	@DeleteMapping("/departments/{emailid}")
	public String deleteDepartment(@PathVariable("emailid") String id) throws DepartmentNotFound {
		Department department = service.deleteDepartmentById(id);
		if (department == null) {
			return "No Department Found";
		} else
			return "Deleted Department";
	}

	@PutMapping("/departments/{emailid}")
	public Department updateDepartment(@PathVariable("emailid") String id, @RequestBody Department department)
			throws DepartmentNotFound {
		Department departmentupdated = service.updateDepartment(id, department);

		return departmentupdated;
	}

}
