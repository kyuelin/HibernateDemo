package dev.kyuelin.hibernate.model;

import javax.persistence.*;

/**
 * Created by kennethlin on 5/16/15.
 */
@Entity
@Table(name = "CAR")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CAR_ID")
    private int id;
    private String make;
    private String model;

    public Car() {}

    public Car(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
