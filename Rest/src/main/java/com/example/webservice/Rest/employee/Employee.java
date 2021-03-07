package com.example.webservice.Rest.employee;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Employee {
    private Integer id;
    @Size(min=2)
    private String name;
    @Min(value=19,message = "age must be greater than 18")
    private Integer age;

protected Employee()
{}
    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
