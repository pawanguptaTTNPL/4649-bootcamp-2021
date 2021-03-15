package com.excercise.JPQL.controller;

import com.excercise.JPQL.entities.Employee;
import com.excercise.JPQL.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeController {

    @Autowired
    EmployeeRepository repository;

    public void createEmployee()
    {
        Employee employee1=new Employee();
        employee1.setFirstName("nikhil");
        employee1.setLastName("kumar");
        employee1.setAge(48);
        employee1.setSalary(45000);
        Employee employee2=new Employee();
        employee2.setFirstName("akhil");
        employee2.setLastName("sharma");
        employee2.setAge(55);
        employee2.setSalary(75000);
        repository.save(employee1);
        repository.save(employee2);
    }

    public void findAllEmployees()
    {
        List<Employee> employeeList=repository. findAllEmployees();
        System.out.println("Id  FirstName LastName Age Salary");
        for(Employee employee:employeeList)
        {
            System.out.println(employee.getId()+"   "+employee.getFirstName()
            +"      "+employee.getLastName()+"      "+employee.getAge()+" "+employee.getSalary());
        }
    }
    public void findAllEmployeesPartialData()
    {
        List<Object[]> employeeList=repository. findAllEmployeesPartialData();
        System.out.println("FirstName LastName ");
        for(Object[] employee:employeeList)
        {
            System.out.println(employee[0]+"    "+employee[1]);
        }

    }
    public void findAllEmployeesByName()
    {
        List<Employee> employeeList=repository.findAllEmployeeByFirstName("Pawan");
        System.out.println("Id  FirstName LastName Age Salary");
        for(Employee employee:employeeList)
        {
            System.out.println(employee.getId()+"   "+employee.getFirstName()
                    +"      "+employee.getLastName()+"      "+employee.getAge()+" "+employee.getSalary());
        }
    }
    public void findEmployeeBetweenGivenSalary()
    {
        List<Employee> employeeList=repository.findEmployeeBetweenGivenSalary(10000,20000);
        System.out.println("Salary Between 10000 and 20000");
        System.out.println("Id  FirstName LastName Age Salary");
        for(Employee employee:employeeList)
        {
            System.out.println(employee.getId()+"   "+employee.getFirstName()
                    +"      "+employee.getLastName()+"      "+employee.getAge()+" "+employee.getSalary());
        }
    }

    @Transactional
    public void deleteEmployeeByName()
    {
        repository.deleteEmployeeByName("Shubham");
    }
///Excercise JPQL

    public void findEmployeeOrderBySalaryAndAge()
    {
        List<Object[]> employeeList=repository.findEmployeeOrderBySalaryAndAge();
        System.out.println("FirstName LastName ");
        for(Object[] employee:employeeList)
        {
            System.out.println(employee[0]+"    "+employee[1]);
        }
    }

    @Transactional
    public void updateSalaryLessThanAverage()
    {
        Integer average = repository.averageSalary();
        System.out.println(">>>>>>>>>>"+average);
        repository.updateSalaryLessThanAverage(20000,average);
    }

    @Transactional
    public void deleteMinSalary()
    {
        Integer minSal = repository.minSalary();
        System.out.println(">>>>>>>>>>"+minSal);
        repository.deleteMinSalary(minSal);
    }


    //Native Query
    public void findAllEmployeeLikeNQ()
    {
        List<Object[]> employeeList=repository.findAllEmployeeLikeNQ();
        System.out.println("Id  FirstName Age ");
        for(Object[] employee:employeeList)
        {
            System.out.println(employee[0]+"   "+employee[1]
                    +"      "+employee[2]);
        }
    }
    @Transactional
    public void deleteByAgeNQ()
    {
        repository.deleteByAgeNQ(45);
    }
}
