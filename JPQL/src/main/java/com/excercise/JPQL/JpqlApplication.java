package com.excercise.JPQL;

import com.excercise.JPQL.controller.EmployeeController;
import com.excercise.JPQL.repos.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JpqlApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(JpqlApplication.class, args);
		EmployeeController employeeController=applicationContext.getBean(EmployeeController.class);
	//	employeeController.createEmployee();
	//	employeeController.findAllEmployees();
	//	employeeController.findAllEmployeesPartialData();
	//	employeeController.findAllEmployeesByName();
	//	employeeController.findEmployeeBetweenGivenSalary();

	//	employeeController.findEmployeeOrderBySalaryAndAge();
	employeeController.updateSalaryLessThanAverage();

		//native Query
	//employeeController.findAllEmployeeLikeNQ();
		//employeeController.deleteByAgeNQ();
	}

}
