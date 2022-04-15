package com.example.demo.services;

import java.util.Optional;

import com.example.demo.entities.Employee;
import com.example.demo.repositries.EmployeeRepository;
//import com.example.demo.util.CustomPasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRepository.findByUsername(username);
        
        //employee.setPassword(passwordEncoder.getPasswordEncoder().encode("asd"));
        //employee.setEmployeeId("333");
        return employee.orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));
    }
    
}
