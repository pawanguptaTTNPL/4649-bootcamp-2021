package com.example.webservice.Rest.employee;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@ApiModel(description="Class Of Employee with details")
//@JsonFilter("PasswordFilter")
public class Employee {
    private Integer id;
    @Size(min=2)
    private String name;
    @Min(value=19,message = "age must be greater than 18")
    @ApiModelProperty(notes = "Age must be greater than 18")
    private Integer age;

 //   @JsonIgnore
    private String password;

protected Employee()
{}
    public Employee(int id, String name, int age,String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.password = password;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
