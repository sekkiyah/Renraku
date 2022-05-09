package com.example.demo.util;

import com.example.demo.entities.Employee;

public class AuthorityUtil {
  public static Boolean hasRole(String role, Employee employee) {
        return employee.getAuthorities()
                .stream()
                .filter(auth -> auth.getAuthority().equals(role))
                .count() > 0;
    }
}
