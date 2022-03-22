package com.test.demo.departmentDTO;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;


public class DepartmentDto {
	@Id
	private Long departmentId;
	@NotNull(message="Cannot be null")
	//@NonNull
	private String departmentName;
	@NotNull(message="Cannot be null")
	//@Email(message="Should be email type")
	private String departmentEmailAddress;
	private String departmentCode;
	private Date date;
    
	@Override
	public String toString() {
	return "DepartmentDto [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", departmentEmailAddress=" + departmentEmailAddress + ", departmentCode=" + departmentCode
				+ ", date=" + date + "]";
	}
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
	public String getDepartmentEmailAddress() {
		return departmentEmailAddress;
	}
	public void setDepartmentEmailAddress(String departmentEmailAddress) {
		this.departmentEmailAddress = departmentEmailAddress;
	}
    public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
