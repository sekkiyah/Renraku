package com.example.demo.config;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.example.demo.entities.Employee;
import com.example.demo.entities.Plan;
import com.example.demo.repositries.EmployeeRepository;
import com.example.demo.repositries.PlanRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository, PlanRepository planRepository){
        return args -> {

            Employee adam = new Employee(
                "123456789", "Adam", "Stevens", LocalDate.of(1997, Month.MAY, 15)
            );
            Employee greg = new Employee(
                "987654321", "Greg", "Tulo", LocalDate.of(1988, Month.NOVEMBER, 22)
            );
            Employee joe = new Employee(
                "456876543", "Joe", "Smith"
            );
            Employee jason = new Employee(
                "321654987", "Jason", "Brown"
            );

            Plan med = new Plan("PPO Plan", "medical");
            Plan den = new Plan("Dental Plan", "dental");


            adam.setEmployeeId("321");
            greg.setEmployeeId("123");
            joe.setEmployeeId("999");
            jason.setEmployeeId("666");

            adam.setUsername("shins");

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String pass = passwordEncoder.encode("asd");
            adam.setPassword(pass);

            repository.saveAll(
                List.of(adam,greg,joe,jason)
            );
            planRepository.saveAll(
                List.of(med,den)
            );

            System.out.println("------Encrypted Password below------");
            System.out.println(pass);
            System.out.println("------------------------------------");

            System.out.println("====================\nApplication started\n====================");
        };
    }
}
