package com.excercise.JPQL.repos;

import com.excercise.JPQL.entities.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    @Query("from Employee")
    List<Employee> findAllEmployees();

    //partial data
    @Query("select em.firstName, em.lastName from Employee em")
    List<Object[]>findAllEmployeesPartialData();

    @Query("from Employee where firstName=:firstName")
    List<Employee>findAllEmployeeByFirstName(@Param("firstName")String firstName);

    @Query("from Employee where empSalary>:min and empSalary<:max")
    List<Employee>findEmployeeBetweenGivenSalary(@Param("min") int min,@Param("max") int max);

    @Modifying
    @Query("delete from Employee where firstName=:firstName")
    void deleteEmployeeByName(@Param("firstName")String firstName);


    @Query("   SELECT firstName, lastName\n" +
            "    FROM Employee\n" +
            "    WHERE salary >(SELECT AVG(salary) FROM Employee)\n" +
            "    ORDER BY salary DESC, age")
    List<Object[]>findEmployeeOrderBySalaryAndAge();

    @Modifying
    @Query("UPDATE Employee e SET e.salary=:salaryval WHERE (select AVG(a.salary)FROM Employee a where Employee)>e.salary")
    void updateSalaryLessThanAverage(@Param("salaryval")Integer salary);
//select pc
//from PushCampaign pc
//where pc.creationDate =
//(select max(creationDate) from PushCampaign inner where inner.bde = pc.bde)

    ///Native Query


//Display the id, first name, age of all employees where last name ends with "singh"
    @Query(value="select empId,empFirstName,empAge from employeeTable" +
            " where empLastName Like '%singh'",nativeQuery = true)
    List<Object[]>findAllEmployeeLikeNQ();



 //Delete all employees with age greater than 45(Should be passed as a parameter)
    @Modifying
 @Query(value="delete from employeeTable where empAge>:agelimit",nativeQuery = true)
 void deleteByAgeNQ(@Param("agelimit")int agelimit);



}
