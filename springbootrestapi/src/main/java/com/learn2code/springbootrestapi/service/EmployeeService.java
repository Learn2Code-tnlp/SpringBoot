package com.learn2code.springbootrestapi.service;

import java.util.List;

import com.learn2code.springbootrestapi.entity.Employee;

public interface EmployeeService {
	
	 public List<Employee> getAllEmployees();
	
     public	 Employee getEmployeeByEmployeeId(int empId);
     
     public Employee saveEmployee(Employee emp);
     
     public void deleteEmployeeById(int employeeId);
	 
	 
}
