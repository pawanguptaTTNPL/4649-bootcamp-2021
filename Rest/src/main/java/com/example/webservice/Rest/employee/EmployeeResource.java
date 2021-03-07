package com.example.webservice.Rest.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmployeeResource {

    @Autowired
    private EmployeeService service;

    @GetMapping("/Employee")
    public List<Employee> retrieveAllEmployee()
    {
        return service.findAll();
    }


    @GetMapping("Employee/{id}")
    public Employee retrieveEmployee(@PathVariable int id)
    {
        Employee emp=service.findOne(id);
        if(emp==null)
            throw new EmployeeNotFound("id-"+id+" NOt Found");

        return emp;
    }
    @DeleteMapping("Employee/{id}")
    public void deleteEmployee(@PathVariable int id)
    {
        Employee emp=service.deleteById(id);
        if(emp==null)
            throw new EmployeeNotFound("id-"+id);

    }

    @PostMapping("/Employee")
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee emp)
    {
        Employee savedEmployee=service.save(emp);

        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedEmployee.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/Employees/update/{id}")
    public  Employee replaceEmployee(@RequestBody Employee emp, @PathVariable int id) {

        Employee employee=service.findOne(id);
        if(employee==null)
            throw new EmployeeNotFound("id-"+id+" NOt Found");

        Employee updateemployee=service.updateEmployee(emp.getName(),emp.getAge(),id);


        return updateemployee;

    }

}
