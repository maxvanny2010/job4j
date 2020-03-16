package ua.emailtime.services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.emailtime.models.User;
import ua.emailtime.view.HibernateRun;

import java.sql.Timestamp;
import java.util.List;


/**
 * UserStorage.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 3/13/2020
 */
public class Hibernate {
    /**
     * Method to find all.
     *
     * @return the of users
     */
    public final List<?> findAll() {
        final Session session = HibernateRun.getFactory().openSession();
        final Transaction transaction = session.beginTransaction();
        final String sql = "FROM User users";
        final List<?> list = session.createQuery(sql).getResultList();
        transaction.commit();
        session.clear();
        session.close();
        return list;
    }

    /**
     * Method to get a user by a login.
     *
     * @param login a login
     * @return a user
     */
    public final User getUserByLogin(final String login) {
        final Session session = HibernateRun.getFactory().openSession();
        final Transaction transaction = session.beginTransaction();
        final String sql = "from User users where login = :login";
        final Query<User> queryOne = session.createQuery(sql, User.class);
        queryOne.setParameter("login", login);
        final User user = queryOne.getSingleResult();
        transaction.commit();
        session.close();
        return user;
    }

    /**
     * Method to delete a user.
     *
     * @param user a user
     */
    public final void onDelete(final User user) {
        final Session session = HibernateRun.getFactory().openSession();
        final Transaction transaction = session.beginTransaction();
        final String sql = "delete from User users where login = :login";
        final var queryOne = session.createQuery(sql);
        queryOne.setParameter("login", user.getLogin());
        queryOne.executeUpdate();
        transaction.commit();
        session.close();
    }

    /**
     * Method to delete a user.
     */
    public final void onDeleteAll() {
        final Session session = HibernateRun.getFactory().openSession();
        final Transaction transaction = session.beginTransaction();
        final String sql = "delete from User users";
        final var query = session.createQuery(sql);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    /**
     * Method to update a user.
     *
     * @param user  a user
     * @param login a login
     * @param pass  a password
     */
    public final void onUpdate(final User user,
                               final String login,
                               final String pass) {
        final Session session = HibernateRun.getFactory().openSession();
        final Transaction transaction = session.beginTransaction();
        user.setLogin(login);
        user.setPassword(pass);
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }

    /**
     * Method to save a user to db.
     *
     * @param user  a user
     * @param login a login
     * @param pass  a password
     */
    public final void onSave(final User user, final String login,
                             final String pass) {
        final Session session = HibernateRun.getFactory().openSession();
        final Transaction transaction = session.beginTransaction();
        user.setLogin(login);
        user.setPassword(pass);
        user.setCreated(new Timestamp(System.currentTimeMillis()));
        session.save(user);
        transaction.commit();
        session.close();
    }
}
