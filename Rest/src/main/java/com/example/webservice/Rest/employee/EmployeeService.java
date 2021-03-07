package com.example.webservice.Rest.employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Component
public class EmployeeService {
    private static List<Employee> employee=new ArrayList<Employee>();
    private static int employeeCount=3;
    static {
        employee.add(new Employee(1,"Pawan",24));
        employee.add(new Employee(2,"Shubham",26));
        employee.add(new Employee(3,"Gaurav",23));
    }
    public List<Employee> findAll()
    {
        return employee;
    }
    public Employee save(Employee employe)
    {
        if(employe.getId()==null)
        {
            employe.setId(++employeeCount);
        }
        employee.add(employe);
        return employe;
    }
    public Employee findOne(int id)
    {
        for(Employee emp:employee)
        {
            if(emp.getId()==id)
                return emp;

        }
        return null;
    }
    public Employee deleteById(int id)
    {
        Iterator<Employee>itr=employee.iterator();
        while(itr.hasNext())
        {
            Employee emp=itr.next();
            if(emp.getId()==id) {
                itr.remove();
                return emp;
            }

        }
        return null;
    }
    public Employee updateEmployee(String name,int age,int id)
    {
        Iterator<Employee>itr=employee.iterator();
        while(itr.hasNext())
        {
            Employee employee=itr.next();
            if(id==employee.getId()) {
                employee.setAge(age);
                employee.setName(name);
                return employee;
            }

        }
        return null;
    }

}
