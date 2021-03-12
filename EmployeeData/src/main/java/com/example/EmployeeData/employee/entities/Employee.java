package com.example.EmployeeData.employee.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="Id")
	private Integer id;
	@Column(name="Name")
	private String name;
	@Column(name="Age")
	private Integer age;
	@Column(name="Location")
	private String location;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	


}
