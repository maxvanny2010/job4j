package ua.dao.persistence;

import org.hibernate.query.NativeQuery;
import ua.dao.models.Car;
import ua.dao.models.Driver;

import java.util.List;

/**
 * ServiceDriver.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/10/2020
 */
public class StoreDriver implements DriverDAO {
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
    public final Driver save(final Driver object) {
        return this.store.wrappers(session -> {
            session.save(object);
            return object;
        });
    }

    @Override
    public final void update(final Driver object) {
        this.store.wrapper(session -> session.update(object));
    }

    @Override
    public final void delete(final Driver object) {
        this.store.wrapper(session -> session.delete(object));
    }

    @Override
    public final Driver getById(final int id, final Class<Driver> dClass) {
        return this.store.wrappers(session -> session.get(dClass, id));
    }

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
     * Method to get.
     *
     * @param name a name of driver
     * @return a driver
     */
    @Override
    public final Driver getDriverByName(final String name) {
        return this.store.wrappers(session -> {
            final String sql = "select d FROM Driver d"
                    + " left join fetch d.cars WHERE d.name= :name";
            return session
                    .createQuery(sql, Driver.class)
                    .setParameter("name", name)
                    .getSingleResult();
        });
    }

    /**
     * Method to get.
     *
     * @param name a name of driver
     * @return a driver
     */
    @Override
    public final List<Car> getCarsByDriverName(final String name) {
        return this.store.wrappers(session -> {
            final String sql = "select c FROM Car c"
                    + " left join fetch c.drivers as d"
                    + "  WHERE d.name= :name";
            return session
                    .createQuery(sql, Car.class)
                    .setParameter("name", name)
                    .list();
        });
    }

}
