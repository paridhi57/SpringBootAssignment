package com.test.demo.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Builder;

@Entity
@Builder
@Document(collection="department")
public class Department{
	
@Id
@GeneratedValue(strategy= GenerationType.AUTO)
private Long departmentId;
private String departmentName;
@Indexed(unique =true)
private String departmentEmailAddress;
public String getDepartmentEmailAddress() {
	return departmentEmailAddress;
}
public void setDepartmentEmailAddress(String departmentEmailAddress) {
	this.departmentEmailAddress = departmentEmailAddress;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
private String departmentCode;
private Date date;
public Long getDepartmentId() {
	return departmentId;
}
public void setDepartmentId(Long departmentId) {
	this.departmentId = departmentId;
}
public String getDepartmentName() {
	return departmentName;
}
public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}

public String getDepartmentCode() {
	return departmentCode;
}
public void setDepartmentCode(String departmentCode) {
	this.departmentCode = departmentCode;
}
}
