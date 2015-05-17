package dev.kyuelin.hibernate.model;

import javax.persistence.*;

/**
 * Created by kennethlin on 5/16/15.
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id=0;
    @Column(name="EMPLOYEE_NAME")
    private String name=null;

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
}
