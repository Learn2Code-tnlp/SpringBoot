package com.learn2code.springbootrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn2code.springbootrestapi.entity.Employee;
import com.learn2code.springbootrestapi.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return empService.getAllEmployees();
	}


	// Swagger 2 configuration
	@GetMapping("/employees/{employeeId}")
	@ApiOperation(value="Find Employee By ID",
	notes="Provide an id to look up a specific employee",
	response=Employee.class)
	public Employee getEmployeeById(@ApiParam(value="ID of the employee you need to retrieve", required=true)
									@PathVariable int employeeId) {
		return empService.getEmployeeByEmployeeId(employeeId);
	}

	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee emp ) {
		return empService.saveEmployee(emp);
	}

	@PutMapping("/employees") 
	public Employee updateEmployee(@RequestBody Employee emp)
	{ 
		return empService.saveEmployee(emp);
	}

	@DeleteMapping(("/employees/{employeeId}"))
	@ApiOperation(value="Delete Employee By ID",
	notes="Provide an id to remove a specific employee",
	response=Employee.class)
	public String deleteEmployee(@ApiParam(value="ID of the employee you need to remove", required=true) 
								@PathVariable int employeeId)
	{ 
		Employee employee = empService.getEmployeeByEmployeeId(employeeId);
		if(employee==null) {
			throw new RuntimeException("No employee found with employee id "+employeeId);
		}

		empService.deleteEmployeeById(employeeId);
		return "deleted successfully";
	}

}
