package com.learn2code.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn2code.springbootrestapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> { 
 // no coding required as we are extending Spring DATA JPA repo
}
