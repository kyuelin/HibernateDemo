package dev.kyuelin.hibernate.dao.impl;

import dev.kyuelin.hibernate.dao.MovieDao;
import dev.kyuelin.hibernate.model.Movie;
import dev.kyuelin.hibernate.utils.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by linken on 5/21/15.
 */
public class MovieDaoImpl implements MovieDao {

    private static SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

    @Override
    public Movie get(Long id) {
        Movie movie;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        movie = (Movie) session.get(Movie.class, id);
        Hibernate.initialize(movie.getActors());
        session.getTransaction().commit();
        return movie;
    }

    @Override
    public void persist(Movie movie) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(movie);
        Hibernate.initialize(movie.getActors());
        session.getTransaction().commit();
    }

    @Override
    public void update(Movie movie) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(movie);
        Hibernate.initialize(movie.getActors());
        session.getTransaction().commit();
    }
}
