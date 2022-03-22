package com.test.demo.service;

import static org.assertj.core.api.Assertions.fail;


import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.demo.exceptionHandle.DepartmentNotFound;
import com.test.demo.Service.DepartmentService;
import com.test.demo.Service.DepartmentServiceImpl;
import com.test.demo.entity.Department;
import com.test.demo.Repository.DepartmentRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DepartmentServiceTest {
	@Autowired
    private DepartmentServiceImpl service;
	@MockBean
	DepartmentRepository DepartmentRepository;
	
	@BeforeEach
	public void setUp()
	{
		Department department=new Department();
		department.setDepartmentName("IT");
		department.setDepartmentEmailAddress("www.paridhi.com");
		department.setDepartmentCode("IT-07");
		department.setDepartmentId(12l);
		Mockito.when(DepartmentRepository.findBydepartmentName("IT")).thenReturn(department);
		System.out.println(department+"hssssssssssssssssssssssssssssssssj");
	}

	@Test
	public void whenValidDepartment() throws DepartmentNotFound
	{ //fail("write");
		Department department=new Department();
		department.setDepartmentName("IT");
		department.setDepartmentEmailAddress("www.paridhi.com");
		department.setDepartmentCode("IT-07");
		department.setDepartmentId(12l);
		Mockito.when(DepartmentRepository.findBydepartmentName("IT")).thenReturn(department);
		System.out.println(department+"hssssssssssssssssssssssssssssssssj");
		System.out.println(DepartmentRepository);
		System.out.println(service);
		String departmentName="IT";
		Department found = service.fetchDepartmentByDepartmentName(departmentName);
		System.out.println(found.getDepartmentName()+"hh");
		assertEquals( departmentName,found.getDepartmentName());
	}
}
