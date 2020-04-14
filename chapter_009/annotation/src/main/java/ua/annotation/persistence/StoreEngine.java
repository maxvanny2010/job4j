package ua.annotation.persistence;

import org.hibernate.query.Query;
import ua.annotation.models.Engine;

/**
 * ServiceEngine.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/10/2020
 */
public class StoreEngine {
    /**
     * field a store.
     */
    private final Store store = Store.instOf();

    /**
     * Method to get.
     *
     * @return the store
     */
    public final Store getStore() {
        return this.store;
    }

    /**
     * Method to add a engine.
     *
     * @param volume a volume of engine
     * @return a engine
     */
    public final Engine getEngineByVolume(final String volume) {
        return this.store.wrappers(session -> {
            final String sql = "FROM Engine engine WHERE volume= :volume";
            final Query<Engine> query = session.createQuery(sql, Engine.class);
            query.setParameter("volume", volume);
            return query.getSingleResult();
        });
    }

    /**
     * Method to add a engine.
     *
     * @throws RuntimeException RuntimeException
     */
    public final void delete() {
        throw new RuntimeException("a table engine to link at table car");
    }

}
