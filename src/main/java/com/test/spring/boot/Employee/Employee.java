package com.test.spring.boot.Employee;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

public class Employee {
	int id;
	String employeeFirstName;
	String employeeLastName;
	String departmentName;
	String empAddress;
	int salary;
	int[] contactNumbers;
	private Date createdDate;
	
	public HashMap<String, String> getEmployeeInfo() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("ID", String.valueOf(getId()));
		map.put("EmployeeFirstName:", getEmployeeFirstName());
		map.put("Employee Last Name: ", getEmployeeLastName());
		map.put("Department Name", String.valueOf(getDepartmentName()));
		map.put("Employee Address", String.valueOf(getEmpAddress()));
		map.put("Salary", String.valueOf(getSalary()));
		map.put("ContactNumbers", String.valueOf(getContactNumbers()));
		return (HashMap<String, String>) map;
	}
	
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int[] getContactNumbers() {
		return contactNumbers;
	}

	public void setContactNumbers(int[] contactNumbers) {
		this.contactNumbers = contactNumbers;
	}

	@JsonSerialize(using=DateSerializer.class)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
