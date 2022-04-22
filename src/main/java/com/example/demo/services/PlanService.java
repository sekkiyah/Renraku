package com.example.demo.services;

import java.util.Optional;
import java.util.Set;

import com.example.demo.entities.Employee;
import com.example.demo.entities.Plan;
import com.example.demo.repositries.PlanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanService {

  @Autowired
  private PlanRepository planRepository;

	public Plan addPlan(Employee employee) {
    Plan plan = new Plan();
    plan.setSubgroup("medical");
    plan.setMember(employee);
    return planRepository.save(plan);
	}

  public Set<Plan> findByMember(Employee employee){
    return planRepository.findByMember(employee);
  }

  public Optional<Plan> findByPlanNumber(int planNumber) {
    return planRepository.findById(planNumber);
  }

  public Plan save(Plan plan){
    return planRepository.save(plan);
  }

}
