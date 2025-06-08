package com.example.ems.controller;

import com.example.ems.dto.EmployeeDto;
import com.example.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
//RequestMapping annotation to define the base url for all the rest apis that we will build within this controller.

public class EmployeeController {
    private EmployeeService employeeService;

    //BUILD ADD EMPLOYEE REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    //BUILD GET EMPLOYEE BY ID REST API.
    //API USING SPRING BOOT--JUST CREATE A METHOD AND THEN WE LL CONVERT THAT
    //METHOD INTO REST API USING ANNOTATIONS.

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto=employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }
    //BUILD GET ALL EMPLOYEES REST API.
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees=employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
    //BUILD UPDATE EMPLOYEE REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto>updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto=employeeService.updateEmployee(employeeId,updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }
    //BUILD DELETE EMPLOYEE REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee((employeeId ) );
        return ResponseEntity.ok("Employee deleted successfully!");
    }
    //BUILD DELETE ALL EMPLOYEE REST API
    @DeleteMapping
    public ResponseEntity<String> deleteAll(){
        employeeService.deleteAll();
        return ResponseEntity.ok("All Employee records deleted.");
    }
    @GetMapping("/firstName")
    public ResponseEntity<List<EmployeeDto>>findEmployeesByFirstName(@RequestParam String firstName){
        List<EmployeeDto> employeeDto=employeeService.findEmployeesByFirstName(firstName);
        return ResponseEntity.ok(employeeDto);
    }
}
