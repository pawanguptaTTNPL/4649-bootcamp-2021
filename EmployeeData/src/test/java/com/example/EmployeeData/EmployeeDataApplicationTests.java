package com.example.EmployeeData;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.print.Pageable;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Sort;
import org.springframework.data.domain.*;
import com.example.EmployeeData.employee.entities.Employee;
import com.example.EmployeeData.employee.repos.EmployeeRepository;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order.Direction;

@SpringBootTest
class EmployeeDataApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	EmployeeRepository repository;
	
//	@Test
//	public void testCreate()
//	{
//		Employee emp=new Employee();
//		emp.setAge(22);
//		emp.setName("Pawan");
//		emp.setLocation("New Delhi");
//		repository.save(emp);
//	
//	}
//	@Test
//	public void testRead()
//	{
//		Employee emp=repository.findById(1).get();
//		assertNotNull(emp);
//		assertEquals("Pawan",emp.getName());
//		
//	}
//	@Test
//	public void testUpdate()
//	{
//		Employee emp=repository.findById(1).get();
//		emp.setName("Gaurav");
//		repository.save(emp);
//	}
//	@Test
//	public void testDelete()
//	{
//		repository.deleteById(8);
//	}
//	@Test
//	public void checkExist()
//	{
//		if(repository.existsById(1))
//		{
//			System.out.println("-----------Exist");
//		}
//	}
//	@Test
//	public void CountRecord()
//	{
//		System.out.println("Total Record : "+repository.count());
//	}
//	
//	
	
	
	
//	@Test
//	public void testfindByName()
//	{
//		List<Employee>employee= repository.findByName("Pawan");
//				for(Employee emp:employee)
//		{
//			System.out.println(emp.getName());
//			}
//		//employee.forEach(p -> System.out.println(p.getId()+" "+p.getName()+" "+p.getAge()+" "+p.getLocation()));
//		
//	}
//	@Test
//	public void testfindByNameContains()
//	{
//		List<Employee>employee= repository.findByNameContains("Paw");
//				for(Employee emp:employee)
//		{
//			System.out.println("It contains Paw : "+emp.getName());
//			}
//		//employee.forEach(p -> System.out.println(p.getId()+" "+p.getName()+" "+p.getAge()+" "+p.getLocation()));
//		
//	}
//	@Test
//	public void testfindByNameLike()
//	{
//		List<Employee>employee= repository.findByNameLike("A%");
//		System.out.println("Names Strating from A character");
//				for(Employee emp:employee)
//		{
//			System.out.println("It contains Paw : "+emp.getName());
//			}
//		//employee.forEach(p -> System.out.println(p.getId()+" "+p.getName()+" "+p.getAge()+" "+p.getLocation()));
//		
//	}
//	@Test
//	public void testfindByIdIn()
//	{
//		List<Employee>employee= repository.findByIdIn(Arrays.asList(1,2,3,4));
//		System.out.println("IN example 1,3,4,4");
//				for(Employee emp:employee)
//		{
//			System.out.println(emp.getName());
//			}
//		//employee.forEach(p -> System.out.println(p.getId()+" "+p.getName()+" "+p.getAge()+" "+p.getLocation()));
//		
//	}
//	
//	@Test
//	public void testfindByNameAndLocation()
//	{
//		List<Employee>employee= repository.findByNameAndLocation("Pawan","New Delhi");
//				for(Employee emp:employee)
//		{
//			System.out.println(emp.getName()+" "+emp.getLocation());
//			}
//		//employee.forEach(p -> System.out.println(p.getId()+" "+p.getName()+" "+p.getAge()+" "+p.getLocation()));
//		
//	}
//	@Test
//	public void testfindByAgeGreaterThan()
//	{
//		List<Employee>employee= repository.findByAgeGreaterThan(22);
//				for(Employee emp:employee)
//		{
//			System.out.println(emp.getName()+" "+emp.getLocation()+" "+emp.getAge());
//			}
//		//employee.forEach(p -> System.out.println(p.getId()+" "+p.getName()+" "+p.getAge()+" "+p.getLocation()));
//		
//	}
//	@Test
//	public void testfindByAgeBetween()
//	{
//		List<Employee>employee= repository.findByAgeBetween(28,32);
//
//		System.out.println("Age between 28 and 32");
//		for(Employee emp:employee)
//{
//	System.out.println(emp.getName()+" "+emp.getLocation()+" "+emp.getAge());
//	}
//
//}
	//Pagination
//	@Test
//	public void testFindAllPaging()
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
//	@Test
//	public void testFindAllPaging()
//	{
//		System.out.println("Sorting and pagination by age");
//		PageRequest pageable = PageRequest.of(0, 2);
//		Page<Employee>result = repository.findAll(pageable);
//		result.forEach(p->System.out.println(p.getName()));
//		
//	
//	}
	@Test
	public void testFindAllSorting()
	{
		//repository.findAll(new Sort("age")).forEach(p->System.out.println(p.getAge()));
		//repository.findAll(new Sort(Direction.DESC, "age"))
		System.out.println("Sorting");
		PageRequest pageable = PageRequest.of(0, 2, null, "name");
		Page<Employee>employee=repository.findAll(pageable);//forEach(p->System.out.println(p.getName()));
	for(Employee emp:employee)
	{
		System.out.println(emp.getAge());
	}
	}
}








