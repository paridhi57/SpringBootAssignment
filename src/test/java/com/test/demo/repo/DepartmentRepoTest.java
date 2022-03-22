package com.test.demo.repo;

import static org.junit.Assert.assertEquals;



import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.test.demo.Repository.DepartmentRepository;
import com.test.demo.entity.Department;

@DataJpaTest
public class DepartmentRepoTest {
 @Autowired
	private DepartmentRepository repo;
  
 private TestEntityManager entityManager;
  
 @BeforeEach
 void setUp()
 {Department department= new Department();
 department.setDepartmentName("IT");
	department.setDepartmentEmailAddress("www.paridhi.com");
	department.setDepartmentCode("IT-07");
	department.setDepartmentId(12l);
	 entityManager.getEntityManager().persist(entityManager);
 }
 
 @Test
 public void whenfindId()
 {
	Department department= repo.findBydepartmentName("IT");
	assertEquals("IT",department.getDepartmentName());
 }
	
}
