package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.demo.entities.Employee;
import com.example.demo.entities.Plan;
import com.example.demo.services.PlanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/plans")
public class PlanController {

  @Autowired
  private PlanService planService;
  
  @PostMapping("")
  public ResponseEntity<?> addPlan(@AuthenticationPrincipal Employee employee, Plan plan){
    Plan newPlan = planService.addPlan(plan);
    return ResponseEntity.ok(newPlan);
  }

  @GetMapping("")
  public ResponseEntity<?> getPlans(@AuthenticationPrincipal Employee employee) {
    //Set<Plan> plansByMember = planService.findByMember(employee);
    //return ResponseEntity.ok(plansByMember);
    List<Plan> plans = planService.findAllPlans();
    return ResponseEntity.ok(plans);
  }

  @GetMapping("{planNumber}")
  public ResponseEntity<?> getPlan(@PathVariable int planNumber, @AuthenticationPrincipal Employee employee){
    Optional<Plan> planOpt = planService.findByPlanNumber(planNumber);
    return ResponseEntity.ok(planOpt.orElse(new Plan()));
  }

  @PutMapping("{planNumber}")
  public ResponseEntity<?> updatePlan(@PathVariable int planNumber,
      @RequestBody Plan plan,
      @AuthenticationPrincipal Employee employee){
    Plan updatedPlan = planService.save(plan);
    return ResponseEntity.ok(updatedPlan);
  }

  @DeleteMapping("{planNumber}")
  public void deleteByPlanNumber(@PathVariable Integer planNumber){
      planService.deletePlan(planNumber);
  }
  
}
