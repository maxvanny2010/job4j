package ua.autos.persistence.dao.store;

import org.hibernate.query.NativeQuery;
import ua.autos.logic.action.utils.actionutil.PropUtil;
import ua.autos.model.ads.Ads;
import ua.autos.model.ads.Status;
import ua.autos.model.user.User;
import ua.autos.persistence.dao.admin.AdminDAO;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/**
 * AdminStore.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/24/2020
 */
public class AdminStore implements AdminDAO {
    /**
     * field a store.
     */
    private final Store store = Store.instOf();

    @SuppressWarnings("unused")
    @Override
    public final Store getStore() {
        return this.store;
    }

    @SuppressWarnings("unused")
    @Override
    public final int save(final User object) {
        return (int) this.store.wrappers(session -> session.save(object));
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

    @SuppressWarnings("unused")
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

    @SuppressWarnings("unused")
    @Override
    public final User findUserBy(final String name) {
        return this.store.wrappers(session -> {
            String sql = "FROM User u WHERE u.name= :name";
            return session.createQuery(sql, User.class)
                    .setParameter("name", name)
                    .getSingleResult();
        });
    }

    @SuppressWarnings("unused")
    @Override
    public final <E> User findUserBy(final String val, final Class<E> tClass) {
        return (User) this.store.wrappers(session -> {
            String table = tClass.getSimpleName().toLowerCase();
            String sql = String.format("FROM %s WHERE values= :value", table);
            return session.createQuery(sql, tClass)
                    .setParameter("value", val)
                    .getSingleResult();
        });
    }

    @SuppressWarnings("unused")
    @Override
    public final List<Ads> findAdsBy(final Status status, final User object) {
        return this.store.wrappers(session -> {
            final String sql = "FROM User u, Ads a"
                    + " WHERE a.status= :status AND u.id=:id";
            return session.createQuery(sql, Ads.class)
                    .setParameter("status", status)
                    .setParameter("id", object.getId())
                    .getResultList();
        });
    }

    @SuppressWarnings("unused")
    @Override
    public final List<Ads> findAdsBy(final User object) {
        return this.store.wrappers(session -> {
            final String sql = "FROM User u WHERE u.id= :id";
            return session.createQuery(sql, Ads.class)
                    .setParameter("id", object.getId())
                    .getResultList();
        });
    }


    @SuppressWarnings("unused")
    @Override
    public final User findBy(final String password) {
        return this.store.wrappers(session -> {
            final String sql = "FROM User u WHERE u.password= :password";
            return session.createQuery(sql, User.class)
                    .setParameter("password", password)
                    .uniqueResult();
        });
    }

    @Override
    public final User findByLogin(final String login) {
        return this.store.wrappers(session -> {
            final String sql = "FROM User u WHERE u.login= :login";
            return session.createQuery(sql, User.class)
                    .setParameter("login", login)
                    .uniqueResult();
        });
    }

    @Override
    public final List<User> findAllUsers() {
        return this.store.wrappers(session -> {
            final String sql = "FROM User";
            return session.createQuery(sql, User.class)
                    .getResultList();
        });
    }

    @Override
    public final List<Ads> findAllAds() {
        return this.store.wrappers(session -> {
            final String sql = "FROM Ads";
            return session.createQuery(sql, Ads.class)
                    .getResultList();
        });
    }

    @Override
    public final User findRoles(final String login, final String password) {
        final AtomicReference<User> rsl = new AtomicReference<>();
        rsl.set(new User("unknown"));
        final Optional<User> adminBy = this.findAdminBy(login, password);
        adminBy.ifPresent(rsl::set);
        final Optional<User> userBy = this.findUserBy(login, password);
        userBy.ifPresent(rsl::set);
        return rsl.get();
    }

    /**
     * Method to find data for admin.
     *
     * @param login a login
     * @param pass  a password
     * @return result
     */
    private Optional<User> findAdminBy(final String login, final String pass) {
        final String file = "admin.properties";
        final Properties props = PropUtil.getProperties(file);
        final String log = props.getProperty("login");
        final String passe = props.getProperty("password");
        if (Objects.equals(log, login) && Objects.equals(pass, passe)) {
            return Optional.of(new User("admin"));
        }
        return Optional.empty();
    }

    /**
     * Method to find data for user.
     *
     * @param login a login
     * @param pass  a password
     * @return result
     */
    private Optional<User> findUserBy(final String login, final String pass) {
        return this.store.wrappers(session -> {
            final String sql = "FROM User u "
                    + " WHERE u.login= :login AND u.password= :password";
            return session.createQuery(sql, User.class)
                    .setParameter("login", login)
                    .setParameter("password", pass)
                    .uniqueResultOptional();
        });
    }

}
