package com.test.spring.boot.Employee;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@RequestMapping(value = EmployeeRestURIConstants.CREATE_NEW_EMPLOYEE, method = RequestMethod.GET)
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
		System.out.println("HttpStatus :"+ HttpStatus.CREATED);
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
		Employee employee = employeeData.get(id);
		if(employee==null)
			System.out.println("HttpStatus :"+ HttpStatus.NO_CONTENT);
		return employee;
	}

	// This Request Will GET_EMPLOYEE_BY_NAME
	@RequestMapping(value = EmployeeRestURIConstants.GET_EMPLOYEE_BY_FIRSTNAME, method = RequestMethod.GET)
	public @ResponseBody Employee getEmployeeByName(@PathVariable("firstname") String firstname) {
		logger.info("GET_EMPLOYEE_BY_NAME.... Please wait...");
		Employee data = new Employee();
		logger.info("Data - Initialized.... " + data.getEmployeeInfo());
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
	public @ResponseBody String deleteEmployeeByLastName(@PathVariable("employeeLastName") String employeeLastName) {

		// If employeeLastName is Null, return proper error message
		if (employeeLastName == null) {
			logger.error("Unable to delete. User with LastName {} not found.", employeeLastName);
			logger.info("Custom Error Message : " + HttpStatus.NOT_FOUND);
		}

		logger.info("DELETE_EMPLOYEE_BY_NAME.... Please wait...");
		// Get the ID of Employee
		Integer datafound = null;
		// Get the entrySet and Iterate over values which matches
		// employeeLastName
		for (Map.Entry<Integer, Employee> entry : employeeData.entrySet()) {
			if (entry.getValue().getEmployeeLastName().equals(employeeLastName)) {
				datafound = entry.getKey();
				break;
			}
		}
		logger.info("Key found for " + employeeLastName + " Key is : " + datafound);
		// Remove the ID which matches employeeLastName value from employeeData
		employeeData.remove(datafound);
		logger.info("Deleting " + employeeLastName + " - From Employee Data");
		return "DELETE Success : " + employeeLastName + " : Data Deleted!!!";
	}
	
	
	// This Request Will PUT_EMPLOYEE_BY_ID
	@RequestMapping(value = EmployeeRestURIConstants.PUT_EMPLOYEE_BY_ID, method = RequestMethod.PUT)
	public @ResponseBody String putEmployeeByID(@PathVariable("id") int empid, @RequestBody Employee employee) {
		logger.info("PUT_EMPLOYEE_BY_ID.... Please wait...");

		// Get Data from Payload and set to EMPLOYEE
		employee.setEmployeeFirstName(employee.getEmployeeFirstName());
		employee.setEmployeeLastName(employee.getEmployeeLastName());
		employee.setDepartmentName(employee.getDepartmentName());
		employee.setEmpAddress(employee.getEmpAddress());
		employee.setSalary(employee.getSalary());
		employee.setContactNumbers(employee.getContactNumbers());
		employee.setCreatedDate(new Date());

		// Get the ID of Employee
		Integer datafound = null;

		// Get the entrySet and Iterate over values which matches
		// employeeLastName
		for (Map.Entry<Integer, Employee> entry : employeeData.entrySet()) {
			if (entry.getValue().getId() == (empid)) {
				datafound = entry.getKey();
				employeeData.put(datafound, employee);
				break;
			}
		}
		logger.info("Key found for Employee-ID :" + empid + " and Key is : " + datafound);

		// Update the employeeData with new data
		logger.info("Updated " + empid + " - With New Employee Data");
		return "PUT Success : " + empid + " : Data UPDATED!!!";
	}

	
	@RequestMapping(value = EmployeeRestURIConstants.GET_MATCH_EMPLOYEES, method = RequestMethod.GET)
	public @ResponseBody Map<Integer, Employee> getEmployees(@PathVariable("id") int id) {
		logger.info("GET ALL MATCHING EMPLOYEES.... Please wait...");
		Collection<Entry<Integer, Employee>> k = employeeData.entrySet();
		logger.info("Created Entry Set...");
		Map<Integer, Employee> resultData= new HashMap<Integer, Employee>();
		for (Iterator<Entry<Integer, Employee>> iterator = k.iterator(); iterator.hasNext();) {
			logger.info("Inside For Loop...");
			Entry<Integer, Employee> entry = (Entry<Integer, Employee>) iterator.next();
			System.out.println("Current Entry : " + entry);
			System.out.println("Current Entry Values : " + entry.getValue());
			if (String.valueOf(entry.getValue().getId()).contains(String.valueOf(id))) {
				System.out.println("Got Matching entry for !!! = " + id);
				System.out.println("Your Values" + entry.getValue());
				resultData.put(entry.getKey(), entry.getValue());
				logger.info("Collected Data!!!...");
			}
		}
		System.out.println("#of Matches ::"+ resultData.size());
		return resultData;
	}
	


}
