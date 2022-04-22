package com.example.demo.repositries;

import java.util.Optional;
import java.util.Set;

import com.example.demo.entities.Employee;
import com.example.demo.entities.Plan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {
  Optional<Plan> findByPlanNumber(Integer planNumber);
  Set<Plan> findByMember(Employee employee);
}
