package com.learn2code.springbootrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn2code.springbootrestapi.repository.EmployeeRepository;
import com.learn2code.springbootrestapi.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	//@Transactional - commenting this as Spring JPA itself provides this txn handling.
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployeeByEmployeeId(int empId) {
		Employee emp = null;
		Optional<Employee> result = empRepo.findById(empId);
		if(result.isPresent()) {
			emp=result.get();
		}
		else {
			throw new RuntimeException("Did not find the employee with Id :"+empId);
		}
		return emp;
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public void deleteEmployeeById(int employeeId) {
		 empRepo.deleteById(employeeId);
	}



}
