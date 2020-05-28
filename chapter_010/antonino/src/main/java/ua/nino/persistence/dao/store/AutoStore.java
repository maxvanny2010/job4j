package ua.nino.persistence.dao.store;

import org.hibernate.query.Query;
import ua.nino.model.auto.Auto;
import ua.nino.model.auto.Brands;
import ua.nino.persistence.dao.auto.AutoDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

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
        final List<List<String>> auto = new ArrayList<>() {{
            add(asList("brand", brand));
            add(asList("model", model));
            add(asList("color", color));
            add(asList("engine", engine));
            add(asList("year", year));
        }};
        final StringBuilder sql = new StringBuilder(
                "SELECT a.id FROM Auto a WHERE ");
        auto.stream()
                .filter(o -> !Objects.equals("", o.get(1)))
                .forEach(o -> sql.append(" a.").append(o.get(0))
                        .append(".values= :").append(o.get(0))
                        .append(" AND"));
        final int off = 4;
        sql.delete(sql.length() - off, sql.length());
        final String request = sql.toString();
        return this.store.wrappers(session -> {
            final Query<Integer> query = session
                    .createQuery(request, Integer.class);
            if (!Objects.equals("", brand)) {
                query.setParameter("brand", brand);
            }
            if (!Objects.equals("", model)) {
                query.setParameter("model", model);
            }
            if (!Objects.equals("", engine)) {
                query.setParameter("engine", engine);
            }
            if (!Objects.equals("", color)) {
                query.setParameter("color", color);
            }
            if (!Objects.equals("", year)) {
                query.setParameter("year", year);
            }
            return query.getResultList();
        });
    }
}
