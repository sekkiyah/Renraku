package com.example.demo.repositries;

import com.example.demo.entities.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
  
}
