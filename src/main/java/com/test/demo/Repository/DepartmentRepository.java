package com.test.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.test.demo.entity.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, Long> {

	public Department findBydepartmentEmailAddress(String id);
	public Department deleteBydepartmentEmailAddress(String id);
	public Department findBydepartmentName(String name);
}
