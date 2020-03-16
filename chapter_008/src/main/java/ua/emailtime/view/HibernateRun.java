package ua.emailtime.view;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.emailtime.models.User;
import ua.emailtime.services.Hibernate;

/**
 * HibernateRuns.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 3/17/2020
 */
public final class HibernateRun {
    /**
     * field a factory.
     */
    private static SessionFactory factory;

    /**
     * Constructor.
     */
    private HibernateRun() {
    }

    /**
     * Method to get.
     *
     * @return a session factory
     */
    public static SessionFactory getFactory() {
        return factory;
    }

    /**
     * Method to set a factory of session.
     **/
    public static void setFactory() {
        if (factory == null) {
            factory = new Configuration().configure().buildSessionFactory();
        }
    }

    /**
     * Method a point enter to program.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        setFactory();
        final Hibernate haber = new Hibernate();
        User one = new User();
        final String loginOne = "AAA";
        final String passOne = "AAA";
        //create
        haber.onSave(one, loginOne, passOne);
        final User resultOne = haber.getUserByLogin(one.getLogin());
        System.out.println(resultOne);
        String loginTwo = "Abb";
        String passTwo = "Abb";
        //update
        try {
            haber.onUpdate(one, loginTwo, passTwo);
            one = haber.getUserByLogin(one.getLogin());
            System.out.println(one);
        } catch (Exception e) {
            System.out.println("Object request " + e.getMessage());
        }
        //delete
        try {
            haber.onDelete(one);
            haber.getUserByLogin(one.getLogin());
        } catch (Exception e) {
            System.out.println("Object request");
        }
        final User three = new User();
        final User two = new User();
        haber.onSave(two, loginOne, passOne);
        haber.onSave(three, loginTwo, passTwo);
        //find all
        final var all = haber.findAll();
        System.out.println(all.toString());
        //delete all
        haber.onDeleteAll();
        getFactory().close();
    }
}
