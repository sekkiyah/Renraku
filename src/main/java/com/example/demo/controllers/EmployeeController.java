package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Employee;
import com.example.demo.services.EmployeeService;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeController {
    //private final EmployeeService employeeService;

    @Autowired
    private EmployeeService employeeService;

    /* @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    } */

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //TESTING
    @GetMapping("{employeeId}")
    public Optional<Employee> getByEmployeeId(@PathVariable String employeeId){
        return employeeService.getByEmployeeId(employeeId);
    }

    /*@GetMapping("{dbId}")
    public Optional<Employee> getByDbId(@PathVariable int dbId){
        return employeeService.getByDbId(dbId);
    }*/
    
    /* @PostMapping
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    } */

    @PostMapping("")
    public ResponseEntity<?> addEmployee(@AuthenticationPrincipal Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.ok(newEmployee);
    }

    @DeleteMapping("{dbId}")
    public void deleteEmployeeById(@PathVariable Integer dbId){
        employeeService.deleteEmployee(dbId);
    }

    @PutMapping("{dbId}")
    public void updateEmployee(@PathVariable Integer dbId, @RequestBody Employee employee){
        employeeService.updateEmployee(dbId, employee);
    }
}
