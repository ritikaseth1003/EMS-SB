package com.example.ems.repository;

import com.example.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //Now that it extends jpaRepository ,it will have a good set of crud  methods to perform the database operations.
    List<Employee> findByFirstName(String firstName);

}
