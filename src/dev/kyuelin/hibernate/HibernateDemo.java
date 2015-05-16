package dev.kyuelin.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linken on 5/16/15.
 */
public class HibernateDemo {
    private static SessionFactory factory;

    private static Family createFamily() {
        Family family = new Family();
        family.setName("Lin");

        List<User> users = new ArrayList<User>();
        users.add(new User("Ken"));
        users.add(new User("Linus"));
        family.setUsers(users);
        return family;
    }

    public static void main(String[] args) {
        factory = HibernateUtil.buildSessionFactory();
        Session session = factory.openSession();
        Transaction txn = null;
        try {
            txn = session.getTransaction();
            txn.begin();
            Family family = createFamily();
            session.persist(family);
            txn.commit();
        } catch (HibernateException he) {
            if (txn != null)
                txn.rollback();
            throw he;
        } finally {
            session.close();
        }
    }
}
