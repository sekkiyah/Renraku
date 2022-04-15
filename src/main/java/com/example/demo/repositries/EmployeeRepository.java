package com.example.demo.repositries;

import java.util.Optional;

import com.example.demo.entities.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
    
    Optional<Employee> findEmployeeBySsn(String ssn);
    Optional<Employee> findByEmployeeId(String employeeId);
    Optional<Employee> findByDbId(Integer dbId);
    Optional<Employee> findByUsername(String username);
    //void updateEmployee(Integer dbId, Employee employee);
}
