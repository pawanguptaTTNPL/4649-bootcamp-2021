package com.example.webservice.Rest.employee;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
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
    public MappingJacksonValue retrieveAllEmployee()
    {
        //return service.findAll();
        List<Employee> emp=service.findAll();
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter
                .filterOutAllExcept("age","name");
        FilterProvider filters = new SimpleFilterProvider().addFilter("PasswordFilter",filter);
        MappingJacksonValue mapping=new MappingJacksonValue(emp);
        mapping.setFilters(filters);
        return mapping;

    }


    @GetMapping("Employee/{id}")
    public EntityModel<Employee> retrieveEmployee(@PathVariable int id)
    {
        Employee emp=service.findOne(id);
        if(emp==null)
            throw new EmployeeNotFound("id-"+id+" NOt Found");
        //Hateoas
        //"all-employee",server_path+"/Employees"
        EntityModel<Employee> resource = EntityModel.of(emp);
        WebMvcLinkBuilder linkTo =  linkTo(methodOn(this.getClass()).retrieveAllEmployee());
       
        resource.add(linkTo.withRel("all-Employee"));

        return resource;
    }
    @DeleteMapping("Employee/{id}")
    public int deleteEmployee(@PathVariable int id)
    {
        Employee emp=service.deleteById(id);
        if(emp==null)
            throw new EmployeeNotFound("id-"+id);
    return id;
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
