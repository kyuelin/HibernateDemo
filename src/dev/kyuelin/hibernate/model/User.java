package dev.kyuelin.hibernate.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by linken on 5/7/15.
 */
@Table(name = "USER")
@Entity
public class User {
    @Column(name = "USER_NAME")
    private String name;
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

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

    public User(String name_) {
        this.name = name_;
    }

    public User() {
    }
}
