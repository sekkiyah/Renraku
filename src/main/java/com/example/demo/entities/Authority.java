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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((authority == null) ? 0 : authority.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Authority other = (Authority) obj;
        if (authority == null) {
            if (other.authority != null)
                return false;
        } else if (!authority.equals(other.authority))
            return false;
        return true;
    }

}
