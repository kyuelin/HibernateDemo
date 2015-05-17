package dev.kyuelin.hibernate;

import dev.kyuelin.hibernate.model.Actor;
import dev.kyuelin.hibernate.model.Family;
import dev.kyuelin.hibernate.model.Movie;
import dev.kyuelin.hibernate.model.User;
import dev.kyuelin.hibernate.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by linken on 5/16/15.
 */
public class HibernateDemo {

    private static SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();


    private static Family createFamily() {
        Family family = new Family();
        family.setName("Lin");

        List<User> users = new ArrayList<>();
        users.add(new User("Ken"));
        users.add(new User("Linus"));
        family.setUsers(users);
        return family;
    }

    private static void persist(Object object) {
        Session session = sessionFactory.openSession();
        Transaction txn = null;
        try {
            txn = session.getTransaction();
            txn.begin();
            session.persist(object);
            txn.commit();
        } catch (HibernateException he) {
            if (txn != null)
                txn.rollback();
            throw he;
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {
        Family family = createFamily();
        persist(family);
        persist(createMovie());
    }

    private static Movie createMovie() {
        Movie movie = new Movie();
        movie.setTitle("The Phantom Menace");
        Set<Actor> actorSet = new HashSet<>();
        movie.setActors(actorSet);

        Actor actor = new Actor("Liam", "Neeson", "Qui-Gon");
        actor.setMovie(movie);
        actorSet.add(actor);

        actor = new Actor("Ewan", "McGregor", "Obi-Won");
        actor.setMovie(movie);
        actorSet.add(actor);

        actor = new Actor("Natalie", "Portman", "Amidala");
        actor.setMovie(movie);
        actorSet.add(actor);

        return movie;
    }
}
