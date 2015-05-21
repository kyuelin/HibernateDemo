package dev.kyuelin.hibernate.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by linken on 5/17/15.
 */
@Entity
@Table(name = "DEPARTMENT")
public class Department {
    @Id
    @Column(name = "DEPARTMENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id = 0;

    @Column(name = "DEPARTMENT_NAME")
    private String name = null;
    @OneToMany
    @JoinTable(name = "DEPARTMENT_EMPLOYEE_JT", joinColumns = @JoinColumn(name = "DEPARTMENT_ID"))
    @Cascade(CascadeType.ALL)
    private List<Employee> employeeList = null;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
