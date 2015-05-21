package dev.kyuelin.hibernate.dao;

import dev.kyuelin.hibernate.model.Movie;

/**
 * Created by linken on 5/21/15.
 */
public interface MovieDao {
    Movie get(Long id);

    void persist(Movie movie);

    void update(Movie movie);
}
