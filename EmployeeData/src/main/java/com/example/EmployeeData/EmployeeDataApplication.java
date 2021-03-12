package com.example.EmployeeData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.EmployeeData.employee.controller.EmployeeResource;

@SpringBootApplication
public class EmployeeDataApplication {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext=SpringApplication.run(EmployeeDataApplication.class, args);
		EmployeeResource employeeResource=applicationContext.getBean(EmployeeResource.class);
	
		
	
//		System.out.println("Perform Creat Operation");
//		employeeResource.create();
//		
//		System.out.println("Perform Update Operation");	
//		employeeResource.Update();
//		
//		System.out.println("Perform Delete Operation");
//		employeeResource.Delete();
		
//		System.out.println("Perform Read Operation");
//		employeeResource.ReadAll();
		
//		System.out.println("Perform Count Operation");
//		employeeResource.CountRecord();
//		
//		System.out.println("Use finder to find Employee by age");
//		employeeResource.findByName();
//		
//		System.out.println("Use finder to find employee starting with A character");
//		employeeResource.findByNameLike();
//		
//		System.out.println("Use finder to find employees whos age between 28 to 32");
//		employeeResource.findByAgeBetween();
		
		System.out.println("Pagination and Sorting");
		employeeResource.FindAllPagingAndSorting();
		
	}

}
