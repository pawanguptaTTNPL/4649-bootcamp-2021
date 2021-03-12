package com.example.EmployeeData.employee.repos;

//import org.hibernate.mapping.List;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeData.employee.entities.Employee;


public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
	
	List<Employee>findByName(String name);
	List<Employee>findByNameAndLocation(String name,String location);
	List<Employee>findByAgeGreaterThan(Integer age);
	
	List<Employee>findByNameContains(String name);
	List<Employee>findByAgeBetween(Integer age1,Integer age2);
	
	List<Employee>findByNameLike(String name);
	List<Employee>findByIdIn(List<Integer>ids);
}
