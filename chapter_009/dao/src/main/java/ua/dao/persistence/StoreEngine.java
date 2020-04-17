package ua.dao.persistence;

import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import ua.dao.models.Engine;

/**
 * ServiceEngine.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/10/2020
 */
public class StoreEngine implements EngineDAO {
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

    @Override
    public final Engine save(final Engine object) {
        return this.store.wrappers(session -> {
            session.save(object);
            return object;
        });
    }

    @Override
    public final void update(final Engine object) {
        this.store.wrapper(session -> session.update(object));
    }

    @Override
    public final void delete(final Engine object) {
        this.store.wrapper(session -> session.delete(object));
    }

    @Override
    public final Engine getById(final int id, final Class<Engine> eClass) {
        return this.store.wrappers(session -> session.get(eClass, id));
    }

    @Override
    public final void deleteEngine() {
        throw new RuntimeException("a table engine to link at table Engine");
    }

    /**
     * Method to delete a table by name.
     *
     * @param name a name
     */
    @Override
    public final void dropTable(final String name) {
        this.store.wrapper(session -> {
            final String delete = "DELETE FROM ";
            final String cascade = " CASCADE";
            final NativeQuery<?> query = session
                    .createSQLQuery(delete + name + cascade);
            query.executeUpdate();
        });
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

}
