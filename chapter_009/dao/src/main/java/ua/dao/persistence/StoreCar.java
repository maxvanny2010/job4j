package ua.dao.persistence;

import org.hibernate.query.NativeQuery;
import ua.dao.models.Car;

import java.util.List;

/**
 * ServiceCar.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/10/2020
 */
public class StoreCar implements CarDAO {
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
    public final Car save(final Car object) {
        return this.store.wrappers(session -> {
            session.save(object);
            return object;
        });
    }

    @Override
    public final void update(final Car object) {
        this.store.wrapper(session -> session.update(object));
    }

    @Override
    public final void delete(final Car object) {
        this.store.wrapper(session -> session.delete(object));
    }

    @Override
    public final Car getById(final int id, final Class<Car> carClass) {
        return this.store.wrappers(session -> session.get(carClass, id));
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
     * @param brand a id
     * @return a car by id
     */
    @Override
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
