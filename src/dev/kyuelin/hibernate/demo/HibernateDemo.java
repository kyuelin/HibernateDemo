package dev.kyuelin.hibernate.demo;

import dev.kyuelin.hibernate.model.*;
import dev.kyuelin.hibernate.utils.HibernateUtil;
import org.hibernate.*;

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

    private static void updateMovie(Long id, String title) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //Movie movie1 = (Movie) session.get(Movie.class, id);
        Movie movie1 = new Movie(id);
        System.out.println(movie1.toString());
        movie1.setTitle(title);
        session.update(movie1);
        session.getTransaction().commit();
        session.close();
    }

    private static Object retrieve(Object object, long id) {
        Session session = sessionFactory.openSession();
        Object obj = null;
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
            transaction.begin();
            obj = session.get(object.getClass(), id);
            Hibernate.initialize(((Movie) obj).getActors());
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null)
                transaction.rollback();
            throw he;
        } finally {
            session.close();
        }

        return obj;
    }

    private static Department createDepartment() {
        Department dept = new Department("Computer Science");
        List<Employee> employees = new ArrayList<Employee>();
        Employee employee = new Employee("A");
        employees.add(employee);
        Employee employee1 = new Employee("B");
        employees.add(employee1);
        dept.setEmployeeList(employees);
        return dept;
    }

    public static void main(String[] args) {
        //Family family = createFamily();
        //persist(family);
        Movie temp = createMovie();
        //persist(movie);
        Movie movie1 = (Movie) retrieve(temp, 10L);
        System.out.println(movie1.toString());
        updateMovie(1L, "test movie name");
        Movie movie2 = (Movie) retrieve(temp, 1L);
        //persist(createDepartment());
        //Movie movie = (Movie) retrieve(new Movie(), 1);
        System.out.println(movie2.toString());
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
