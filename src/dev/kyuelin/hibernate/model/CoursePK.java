package dev.kyuelin.hibernate.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by kennethlin on 5/16/15.
 */
@Embeddable
public class CoursePK implements Serializable {
    private String tutor = null;
    private String title = null;

    public CoursePK() {
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
