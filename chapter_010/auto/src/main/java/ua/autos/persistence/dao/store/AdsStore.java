package ua.autos.persistence.dao.store;

import ua.autos.model.ads.Ads;
import ua.autos.model.ads.Status;
import ua.autos.model.user.User;
import ua.autos.persistence.dao.ads.AdsDAO;

import java.util.List;

/**
 * AdsStore.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/20/2020
 */
public class AdsStore implements AdsDAO {
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
    public final int save(final Ads object) {
        return (int) this.store.wrappers(session -> session.save(object));
    }

    @Override
    public final void update(final Ads object) {
        this.store.wrapper(session -> session.update(object));
    }

    @Override
    public final Ads getById(final int id) {
        return this.store.wrappers(session -> session.get(Ads.class, id));
    }

    @Override
    public final void delete(final Ads object) {
        this.store.wrapper(session -> session.delete(object));
    }

    @SuppressWarnings("unused")
    @Override
    public final void deleteAds(final String id) {
        this.store.wrapper(session -> {
            final String sql = "DELETE FROM Ads a WHERE a.id= :id";
            session.createQuery(sql, Ads.class).setParameter("id", id)
                    .executeUpdate();
        });
    }

    @SuppressWarnings("unused")
    @Override
    public final List<Ads> findAdsBy(final Status status, final User user) {
        return this.store.wrappers(session -> {
            final String sql = "FROM User u, Ads a "
                    + " WHERE a.status= :status AND u.id= :id";
            return session.createQuery(sql, Ads.class)
                    .setParameter("status", status)
                    .setParameter("id", user.getId())
                    .getResultList();
        });
    }

    @Override
    public final Ads findAdsByIdAuto(final Integer id) {
        return this.store.wrappers(session -> {
            final String sql = "FROM Ads a WHERE a.id= :id";
            return session.createQuery(sql, Ads.class)
                    .setParameter("id", id)
                    .uniqueResult();
        });
    }
}
