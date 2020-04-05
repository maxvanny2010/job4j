package ua.driver.services;

import ua.driver.models.Car;
import ua.driver.models.Driver;

import java.util.List;

/**
 * ServiceDriver.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/10/2020
 */
public class StoreDriver {
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
     * Method to get.
     *
     * @param name a name of driver
     * @return a driver
     */
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
