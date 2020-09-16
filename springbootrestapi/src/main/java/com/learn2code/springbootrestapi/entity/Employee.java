package com.learn2code.springbootrestapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="employee")
@ApiModel(description="Details of an Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@ApiModelProperty(notes="Unique id of the Employee")
	private int id;
	
	@Column(name="first_name")
	@ApiModelProperty(notes="The Employee's first name")
	private String firstName;
	
	@Column(name="last_name")
	@ApiModelProperty(notes="The Employee's last name")
	private String lastName;
	
	@Column(name="email")
	@ApiModelProperty(notes="The Employee's email")
	private String email;
	
	public Employee() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
