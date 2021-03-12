package com.example.EmployeeData.employee.controller;
//import java.awt.print.Pageable;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;

//import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.example.EmployeeData.employee.entities.Employee;
import com.example.EmployeeData.employee.repos.EmployeeRepository;
//import com.mysql.cj.x.protobuf.MysqlxCrud.Order.Direction;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
@Service
public class EmployeeResource {

	

	@Autowired
	EmployeeRepository repository;
	
	public void ReadAll()
	{
		List<Employee>employees=(List<Employee>) repository.findAll();

		System.out.println("Details of all empployees");
		System.out.println("Id  Name  Age  Location");
		for(Employee emp:employees)
		{
			System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getAge()+" "+emp.getLocation());
		}
	}
	
	public void create()
	{
		System.out.println("Data is Created");
		
		
		Employee emp=new Employee();
		emp.setAge(22);
		emp.setName("Abhisheka");
		emp.setLocation("Lucknow");
		repository.save(emp);
		System.out.println(emp.getName()+" "+emp.getAge()+" "+emp.getLocation());
	
	}
	
	public void Read()
	{
		Employee emp=repository.findById(1).get();
				
	}
	
	public void Update()
	{
		Employee emp=repository.findById(14).get();
		emp.setName("Abhi");
		repository.save(emp);
	}
	
	public void Delete()
	{
		repository.deleteById(14);
	}
	
	public void checkExist()
	{
		if(repository.existsById(1))
		{
			System.out.println("-----------Exist");
		}
	}
	
	public void CountRecord()
	{
		System.out.println("Total Record : "+repository.count());
	}
	
	
	
	
	
	
	public void findByName()
	{
		System.out.println("Searching By Pawan ");
		List<Employee>employee= repository.findByName("Pawan");
				for(Employee emp:employee)
		{
			System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getAge()+" "+emp.getLocation());
			}
		//employee.forEach(p -> System.out.println(p.getId()+" "+p.getName()+" "+p.getAge()+" "+p.getLocation()));
		
	}
	
	public void findByNameContains()
	{
		List<Employee>employee= repository.findByNameContains("Paw");
				for(Employee emp:employee)
		{
			System.out.println("It contains Paw : "+emp.getName());
			}
		//employee.forEach(p -> System.out.println(p.getId()+" "+p.getName()+" "+p.getAge()+" "+p.getLocation()));
		
	}
	
	public void findByNameLike()
	{
		List<Employee>employee= repository.findByNameLike("A%");
		System.out.println("Names Strating from A character");
				for(Employee emp:employee)
		{
			System.out.println(emp.getName());
			}
	
		
	}
	
	public void findByIdIn()
	{
		List<Employee>employee= repository.findByIdIn(Arrays.asList(1,2,3,4));
		System.out.println("IN example 1,3,4,4");
				for(Employee emp:employee)
		{
			System.out.println(emp.getName());
			}
		//employee.forEach(p -> System.out.println(p.getId()+" "+p.getName()+" "+p.getAge()+" "+p.getLocation()));
		
	}
	
	
	public void findByNameAndLocation()
	{
		List<Employee>employee= repository.findByNameAndLocation("Pawan","New Delhi");
				for(Employee emp:employee)
		{
			System.out.println(emp.getName()+" "+emp.getLocation());
			}
		//employee.forEach(p -> System.out.println(p.getId()+" "+p.getName()+" "+p.getAge()+" "+p.getLocation()));
		
	}
	
	public void findByAgeGreaterThan()
	{
		List<Employee>employee= repository.findByAgeGreaterThan(22);
				for(Employee emp:employee)
		{
			System.out.println(emp.getName()+" "+emp.getLocation()+" "+emp.getAge());
			}
		//employee.forEach(p -> System.out.println(p.getId()+" "+p.getName()+" "+p.getAge()+" "+p.getLocation()));
		
	}
	
	public void findByAgeBetween()
	{
		List<Employee>employee= repository.findByAgeBetween(28,32);

		System.out.println("Age between 28 and 32");
		for(Employee emp:employee)
{
	System.out.println(emp.getName()+" "+emp.getLocation()+" "+emp.getAge());
	}

}
	
    public void FindAllPagingAndSorting()
    {
       
    	System.out.println("Page Size : 10 and Sort By Age");
        Pageable pageable = PageRequest.of(0,4, (Sort.by(new Sort.Order(null,"age") )));
        repository.findAll(pageable).forEach(employee -> System.out.println(employee.getId()+" -> "+employee.getName()+" -> "+employee.getAge()));
    }
	//Pagination
	
//	public void FindAllPaging()
//	{
//		System.out.println("Sorting and pagination by age");
//		PageRequest pageable = PageRequest.of(0, 2, null, "age");
//		Page<Employee>emp=repository.findAll(pageable);
//		for(Employee employee:emp)
//		{
//			System.out.println(employee.getName());
//		}
//		
//	
//	}
	
//	public void FindAllPaging()
//	{
//		System.out.println("Sorting and pagination by age");
//		PageRequest pageable = PageRequest.of(0, 2);
//		Page<Employee>result = repository.findAll(pageable);
//		result.forEach(p->System.out.println(p.getName()));
//		
//	
//	}
	
//	public void FindAllSorting()
//	{
//		//repository.findAll(new Sort("age")).forEach(p->System.out.println(p.getAge()));
//		//repository.findAll(new Sort(Direction.DESC, "age"))
//		System.out.println("Sorting");
//		PageRequest pageable = PageRequest.of(0, 2, null, "name");
//		Page<Employee>employee=repository.findAll(pageable);//forEach(p->System.out.println(p.getName()));
//	for(Employee emp:employee)
//	{
//		System.out.println(emp.getAge());
//	}
//	}
}
