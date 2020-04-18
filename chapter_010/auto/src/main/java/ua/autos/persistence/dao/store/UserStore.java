package ua.autos.persistence.dao.store;

import ua.autos.model.ads.Ads;
import ua.autos.model.user.User;
import ua.autos.persistence.dao.user.UserDAO;

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

}
