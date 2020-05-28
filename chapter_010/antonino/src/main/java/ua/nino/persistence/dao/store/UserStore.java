package ua.nino.persistence.dao.store;

import ua.nino.model.ads.Ads;
import ua.nino.model.user.User;
import ua.nino.persistence.dao.user.UserDAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * UserStore.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/20/2020
 */
public class UserStore implements UserDAO {
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
    public final int save(final User object) {
        return (int) this.store.wrappers(session ->
                session.save(object));
    }

    @Override
    public final void update(final User object) {
        this.store.wrapper(session -> session.update(object));
    }

    @Override
    public final User getById(final int id) {
        return this.store.wrappers(session -> session.get(User.class, id));
    }

    @Override
    public final void delete(final User object) {
        this.store.wrapper(session -> session.delete(object));
    }

    /**
     * Method to find user by ads.
     *
     * @param ads a ads
     * @return a user
     */
    public final Optional<User> getUserIdByAds(final Ads ads) {
        return this.store.wrappers(session -> {
            final String sql = "SELECT distinct user"
                    + " FROM Ads a WHERE a.id= :id";
            return session.createQuery(sql, User.class)
                    .setParameter("id", ads.getId())
                    .uniqueResultOptional();
        });
    }

    /**
     * Method to get.
     *
     * @param aStart a start of filter
     * @param aEnd   a end of filter
     * @return result by ads list
     */
    public final List<Ads> getDateFilter(final String aStart,
                                         final String aEnd) {
        return this.store.wrappers(session -> {
            final LocalDate start = LocalDate.parse(aStart).minusDays(1);
            final LocalDate ends = LocalDate.parse(aEnd).plusDays(1);
            final String sql = "FROM Ads a"
                    + " WHERE  a.times BETWEEN :start AND :ends";
            return session.createQuery(sql, Ads.class)
                    .setParameter("start", start)
                    .setParameter("ends", ends)
                    .getResultList();
        });
    }
}
