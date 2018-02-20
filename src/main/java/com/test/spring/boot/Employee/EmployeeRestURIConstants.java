package com.test.spring.boot.Employee;

public class EmployeeRestURIConstants {

	public static final String DUMMY_EMPLOYEE = "/rest/employee/dummy";
	public static final String GET_EMPLOYEE_LIST = "/rest/employee/get/all";
	public static final String GET_EMPLOYEE_BY_ID = "/rest/employee/get/id/{id}";
	public static final String GET_EMPLOYEE_BY_FIRSTNAME = "/rest/employee/get/name/{firstname}";
	public static final String CREATE_NEW_EMPLOYEE = "/rest/employee/create";
	public static final String DELETE_EMPLOYEE_BY_ID = "/rest/employee/delete/id/{id}";
	public static final String DELETE_EMPLOYEE_BY_LASTNAME = "/rest/employee/delete/name/{employeeLastName}";
	public static final String PUT_EMPLOYEE_BY_ID = "/rest/employee/put/{id}";
	public static final String GET_MATCH_EMPLOYEES= "/rest/employee/get/match/{id}";
//	public static final String PATCH_EMPLOYEE = "/rest/employee/patch/{id}";
//	public static final String OPTIONS_EMPLOYEE = "/rest/employee/options/{id}";
}
