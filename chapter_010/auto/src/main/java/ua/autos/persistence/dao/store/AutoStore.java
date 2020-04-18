package ua.autos.persistence.dao.store;

import ua.autos.model.auto.Auto;
import ua.autos.model.auto.Brands;
import ua.autos.persistence.dao.auto.AutoDAO;

import java.util.List;

/**
 * AutoStore.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/20/2020
 */
public class AutoStore implements AutoDAO {
    /**
     * field a store.
     */
    private final Store store = Store.instOf();

    @SuppressWarnings("unused")
    @Override
    public final Store getStore() {
        return this.store;
    }

    @Override
    public final int save(final Auto object) {
        return (int) this.store.wrappers(session -> session.save(object));
    }

    @SuppressWarnings("unused")
    @Override
    public final void update(final Auto object) {
        this.store.wrapper(session -> session.update(object));
    }

    @Override
    public final Auto getById(final int id) {
        return this.store.wrappers(session -> session.get(Auto.class, id));
    }

    @SuppressWarnings("unused")
    @Override
    public final void delete(final Auto object) {
        this.store.wrapper(session -> session.delete(object));
    }

    @Override
    public final List<?> findByValue(final String value,
                                     final Class<?> tClass) {
        return this.store.wrappers(session -> {
            final String table = tClass.getSimpleName();
            String sql = String.format("FROM %s WHERE values= :value", table);
            return session.createQuery(sql, tClass)
                    .setParameter("value", value)
                    .getResultList();
        });
    }

    @Override
    public final Brands getModels(final String value) {
        return this.store.wrappers(session -> {
            final String sql = "FROM Brands b WHERE b.values= :value";
            return session.createQuery(sql, Brands.class)
                    .setParameter("value", value)
                    .uniqueResult();
        });
    }

    @Override
    public final List<Integer> findAutoId(final String brand,
                                          final String model,
                                          final String engine,
                                          final String year,
                                          final String color) {
        return this.store.wrappers(session -> {
            final String sql = "SELECT a.id FROM Auto a"
                    + " WHERE (a.brand.values= :brand AND :brand != '')"
                    + " AND (a.model.values= :model AND :model!= '')"
                    + " AND (a.engine.values= :engine AND :engine != '')"
                    + " AND (a.year.values= :year AND :year != '')"
                    + " AND (a.color.values= :color AND :color != '')";
            return session.createQuery(sql, Integer.class)
                    .setParameter("brand", brand)
                    .setParameter("model", model)
                    .setParameter("engine", engine)
                    .setParameter("year", year)
                    .setParameter("color", color)
                    .getResultList();
        });
    }
}
