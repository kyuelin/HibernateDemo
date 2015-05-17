package dev.kyuelin.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by kennethlin on 5/16/15.
 */
@Entity
@Table(name = "COURSE")
public class Course {
    @Id
    private CoursePK id = null;
    private int totalStudents = 0;
    private int registeredStudents = 0;

    public Course() {}

    public Course (String title, String tutor) {
        id = new CoursePK();
        id.setTitle(title);
        id.setTutor(tutor);
    }

    public CoursePK getId() {
        return id;
    }

    public void setId(CoursePK id) {
        this.id = id;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public int getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(int registeredStudents) {
        this.registeredStudents = registeredStudents;
    }
}
