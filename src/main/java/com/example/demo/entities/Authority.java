package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Authority implements GrantedAuthority{
    //private static final long serialVersionUID = -6520888182797362903L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dbId;
    private String authority;
    @ManyToOne(optional = false)
    private Employee employee;

    public Authority () {}

    public Authority (String authority){
        this.authority = authority;
    }

    /**
     * @return the dbId
     */
    public int getDbId() {
        return dbId;
    }
    /**
     * @param dbId the dbId to set
     */
    public void setDbId(int dbId) {
        this.dbId = dbId;
    }
    /**
     * @return the authority
     */
    public String getAuthority() {
        return authority;
    }
    /**
     * @param authority the authority to set
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }
    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }
    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
