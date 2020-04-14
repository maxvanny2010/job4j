package ua.annotation.persistence;

import ua.annotation.models.Car;

import java.util.List;

/**
 * ServiceCar.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/10/2020
 */
public class StoreCar {
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
     * @param brand a id
     * @return a car by id
     */
    public final List<Car> getByBrand(final String brand) {
        return this.store.wrappers(session -> {
            final String sql = "FROM Car car left join fetch car.engine"
                    + " WHERE car.brand= :brand";
            return session
                    .createQuery(sql, Car.class)
                    .setParameter("brand", brand)
                    .list();
        });
    }
}
