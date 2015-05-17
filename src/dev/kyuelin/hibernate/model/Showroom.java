package dev.kyuelin.hibernate.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by kennethlin on 5/16/15.
 */
@Entity
@Table(name = "SHOWROOM")
public class Showroom {
    @Id
    @Column(name="SHOWROOM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id = 0;
    @Column(name="SHOWROOM_MANAGER")
    private String manager = null;
    @Column(name = "SHOWROOM_LOC")
    private String location = null;
    @OneToMany
    @JoinColumn(name="SHOWROOM_ID")
    @Cascade(CascadeType.ALL)
    private List<Car> cars = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
