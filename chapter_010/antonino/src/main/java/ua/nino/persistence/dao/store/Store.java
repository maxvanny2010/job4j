package ua.nino.persistence.dao.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Store.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
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
     * @return the instance of store
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
        final Transaction transaction = session.beginTransaction();
        try {
            final T rsl = command.apply(session);
            transaction.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
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
}
