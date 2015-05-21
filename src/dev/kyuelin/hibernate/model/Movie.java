package dev.kyuelin.hibernate.model;

import dev.kyuelin.hibernate.dao.MovieDao;
import dev.kyuelin.hibernate.dao.impl.MovieDaoImpl;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by kennethlin on 5/16/15.
 */
@Entity
@Table(name = "MOVIE")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MOVIE_ID")
    private long id = 0;

    private String title = null;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    @Cascade(CascadeType.ALL)
    private Set<Actor> actors = null;

    public Movie() {
    }

    public Movie(Long id) {
        this.id = id;
    }

    public Movie(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", actors=" + actors +
                '}';
    }

    public static void main(String[] args) {
        MovieDao dao = new MovieDaoImpl();
        Movie movie = dao.get(23L);
        System.out.println(movie.toString());
    }
}
