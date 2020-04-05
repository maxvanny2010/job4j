package ua.driver.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Service.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/10/2020
 */
public final class Store {

    /**
     * field a factory.
     */
    private static final SessionFactory FACTORY = new Configuration()
            .configure().buildSessionFactory();
    /**
     * field a store.
     */
    private static final Store STORE = new Store();

    /**
     * Constructor.
     */
    private Store() {
    }

    /**
     * Method to get.
     *
     * @return a instance of store
     */
    public static Store instOf() {
        return STORE;
    }

    /**
     * Method to apply session command.
     *
     * @param <T>     type
     * @param command a command
     * @return result
     */
    public <T> T wrappers(final Function<Session, T> command) {
        final Session session = FACTORY.openSession();
        try (session) {
            final Transaction transaction = session.beginTransaction();
            final T rsl = command.apply(session);
            transaction.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    /**
     * Method to apply session command.
     *
     * @param command a command
     */
    public void wrapper(final Consumer<Session> command) {
        this.wrappers(session -> {
            command.accept(session);
            return null;
        });
    }

    /**
     * Method to save object to db.
     *
     * @param <T>    type
     * @param object a object
     * @return the save object
     */
    public <T> T save(final T object) {
        return this.wrappers(session -> {
            session.save(object);
            return object;
        });
    }

    /**
     * Method to update object in db.
     *
     * @param <T>    type
     * @param object a object
     */
    public <T> void update(final T object) {
        this.wrapper(session -> session.update(object));
    }

    /**
     * Method to delete object from db.
     *
     * @param <T>    type
     * @param object a object
     */
    public <T> void delete(final T object) {
        this.wrapper(session -> session.delete(object));
    }

    /**
     * Method to get.
     *
     * @param <T>    type
     * @param id     a id
     * @param tClass a required class
     * @return the instance by object
     */
    public <T> T getById(final int id, final Class<T> tClass) {
        return this.wrappers(session -> session.get(tClass, id));
    }

    /**
     * Method to delete a table by name.
     *
     * @param name a name
     */
    public void dropTable(final String name) {
        this.wrapper(session -> {
            final String delete = "DELETE FROM ";
            final String cascade = " CASCADE";
            final NativeQuery<?> query = session
                    .createSQLQuery(delete + name + cascade);
            query.executeUpdate();
        });
    }

}
