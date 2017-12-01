package com.test.spring.boot.Employee;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	// Logging purpose
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	// Hash Map used to Store Employee Details - Instead of DataBase
	Map<Integer, Employee> employeeData = new HashMap<Integer, Employee>();

	// This Request Will Create Dummy User and get data
	@RequestMapping(value = EmployeeRestURIConstants.DUMMY_EMPLOYEE, method = RequestMethod.GET)
	public @ResponseBody Employee getDummyEmployee() {
		logger.info("Creating One Dummy Employee and Publishing Data.... Please wait...");
		int[] contactNumbers = { 123456780, 435345 };
		Employee dummyEmployee = new Employee();
		dummyEmployee.setId(000);
		dummyEmployee.setEmployeeFirstName("Dummy_FirstName");
		dummyEmployee.setEmployeeLastName("Dummy_LastName");
		dummyEmployee.setDepartmentName("Dummy_Department");
		dummyEmployee.setEmpAddress("Dummy_Address");
		dummyEmployee.setSalary(1000);
		dummyEmployee.setContactNumbers(contactNumbers);
		employeeData.put(1000, dummyEmployee);
		return dummyEmployee;
	}

	// This Request Will Create New User
	@RequestMapping(value = EmployeeRestURIConstants.CREATE_NEW_EMPLOYEE, method = RequestMethod.POST)
	public @ResponseBody Employee createEmployee(@RequestBody Employee employee) {
		logger.info("Started Create Employee Call...");
		employee.setEmployeeFirstName(employee.getEmployeeFirstName());
		employee.setEmployeeLastName(employee.getEmployeeLastName());
		employee.setDepartmentName(employee.getDepartmentName());
		employee.setEmpAddress(employee.getEmpAddress());
		employee.setSalary(employee.getSalary());
		employee.setContactNumbers(employee.getContactNumbers());
		employee.setCreatedDate(new Date());
		employeeData.put(employee.getId(), employee);
		logger.info(" ==== Employee Creation Success ===");
		return employee;
	}

	// This Request Will ALL Employees
	@RequestMapping(value = EmployeeRestURIConstants.GET_EMPLOYEE_LIST, method = RequestMethod.GET)
	public @ResponseBody Map<Integer, Employee> getEmployeelist() {
		logger.info("Collecting All Employee Details.... Please wait...");
		return employeeData;
	}

	// This Request Will GET_EMPLOYEE_BY_ID
	@RequestMapping(value = EmployeeRestURIConstants.GET_EMPLOYEE_BY_ID, method = RequestMethod.GET)
	public @ResponseBody Employee getEmployeeByID(@PathVariable("id") int id) {
		logger.info("GET_EMPLOYEE_BY_ID.... Please wait...");
		System.out.println("Result = " + employeeData.get(id));
		return employeeData.get(id);
	}

	// This Request Will GET_EMPLOYEE_BY_NAME
	@RequestMapping(value = EmployeeRestURIConstants.GET_EMPLOYEE_BY_FIRSTNAME, method = RequestMethod.GET)
	public @ResponseBody Employee getEmployeeByName(@PathVariable("firstname") String firstname) {
		logger.info("GET_EMPLOYEE_BY_NAME.... Please wait...");
		Employee data = new Employee();
		logger.info("Data - Initialized.... "+data.getEmployeeInfo());
		Collection<Entry<Integer, Employee>> k = employeeData.entrySet();
		logger.info("Created Entry Set...");
		for (Iterator<Entry<Integer, Employee>> iterator = k.iterator(); iterator.hasNext();) {
			logger.info("Inside For Loop...");
			Entry<Integer, Employee> entry = (Entry<Integer, Employee>) iterator.next();
			System.out.println("Current Entry : " + entry);
			System.out.println("Current Entry Values : " + entry.getValue());
			if (entry.getValue().getEmployeeFirstName().equalsIgnoreCase(firstname)) {
				System.out.println("Got You!!! = " + firstname);
				System.out.println("Your Values" + entry.getValue());
				data = entry.getValue();
				logger.info("Collected Data!!!...");
			}
		}
		return data;
	}
	

	// This Request Will DELETE_EMPLOYEE_BY_ID
	@RequestMapping(value = EmployeeRestURIConstants.DELETE_EMPLOYEE_BY_ID, method = RequestMethod.DELETE)
	public @ResponseBody Employee deleteEmployeeByID(@PathVariable("id") int id) {
		logger.info("DELETE_EMPLOYEE_BY_ID.... Please wait...");
		System.out.println("Result = " + employeeData.get(id));
		return employeeData.remove(id);
	}
	
	// This Request Will DELETE_EMPLOYEE_BY_NAME
	@RequestMapping(value = EmployeeRestURIConstants.DELETE_EMPLOYEE_BY_LASTNAME, method = RequestMethod.DELETE)
	public @ResponseBody Employee deleteEmployeeByLastName(@PathVariable("employeeLastName") String employeeLastName) {
		logger.info("DELETE_EMPLOYEE_BY_NAME.... Please wait...");
		Employee data = new Employee();
		Collection<Entry<Integer, Employee>> k = employeeData.entrySet();
		logger.info("Created Entry Set...");
		for (Iterator<Entry<Integer, Employee>> iterator = k.iterator(); iterator.hasNext();) {
			logger.info("Inside For Loop...");
			Entry<Integer, Employee> entry = (Entry<Integer, Employee>) iterator.next();
			System.out.println("Current Entry : " + entry);
			System.out.println("Current Entry Values : " + entry.getValue());
			if (entry.getValue().getEmployeeLastName().equalsIgnoreCase(employeeLastName)) {
				System.out.println("Got You!!! = " + employeeLastName);
				System.out.println("Your Values" + entry.getValue());
				data = entry.getValue();
				logger.info("Collected Data!!!...");
				data = employeeData.remove(employeeLastName);
				logger.info(" $$$ Removed Employee By LastName !!!...");
			}
		}
		return data;
	}
	
	// This Request Will PUT_EMPLOYEE_BY_ID
	// @RequestMapping(value=EmployeeRestURIConstants.PUT_EMPLOYEE_BY_ID,
	// method=RequestMethod.PUT)
	// public @ResponseBody Employee putEmployeeByID(@PathVariable("id") int
	// empid) {
	// logger.info("PUT_EMPLOYEE_BY_ID.... Please wait...");
	// Employee emp = employeeData.get(empid);
	// employeeData.remove(empid);
	// return emp;
	// }
}
