package com.example.demo.entities;

import java.time.LocalDate;
// import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
// import java.util.List;
//import java.util.ArrayList;
//import java.util.List;
//import java.time.Period;
//import java.util.Random;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "employee")
public class Employee implements UserDetails {
    @Id
    @Column(name = "dbId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dbId;

    private String ssn;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;
    private String employeeId;
    private String username;
    @JsonIgnore
    private String password;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
    private Set<Authority> authorities = new HashSet<>();
    

    //private List<Plan> election = new ArrayList<>();
    
    //private int age;

    
    /**
     * @return the election
     
    public List<Plan> getElection() {
        return election;
    } */

    /**
     * @param election the election to set
     
    public void setElection(List<Plan> election) {
        this.election = election;
    } */

    public Employee(){}

    /**
     * @param firstName
     * @param lastName
     * @param ssn
     */
    public Employee(String ssn, String firstName, String lastName) {
        //generateDbId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    /**
     * @param firstName
     * @param lastName
     * @param dob
     */
    public Employee(String ssn, String firstName, String lastName, LocalDate dob) {
        //generateDbId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.dob = dob;
    }

    /* public void generateDbId(){
        Random random = new Random();
        int generatedNumber = random.nextInt(999999999) + 1;
        this.dbId = generatedNumber;
    } */
    
    /**
     * @return the age
     */
    /*public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }*/

    /**
     * @param age the age to set
     */
    /*public void setAge(int age) {
        this.age = age;
    }*/
    
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the dob
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    /**
     * @return the ssn
     */
    public String getSsn() {
        return ssn;
    }

    /**
     * @param ssn the ssn to set
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    /**
     * @return the employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * @param the employeeId to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the employeeId
     */
    public int getDbId() {
        return dbId;
    }

    /**
     * @param id the id to set
     */
    public void setDbId(int dbId) {
        this.dbId = dbId;
    }

    //TESTING
    public void updateEmployee(Employee employee) {
        if(!employee.getFirstName().equals(this.firstName)){
            this.firstName = employee.getFirstName();
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // List<GrantedAuthority> role = new ArrayList<>();
        // role.add(new Authority("ROLE_EMPLOYEE"));
        // return role;
        return authorities;
    }

    /**
     * @param authorities the authorities to set
     */
    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
