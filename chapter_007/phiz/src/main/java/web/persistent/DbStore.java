package web.persistent;

import org.apache.commons.dbcp2.BasicDataSource;
import web.logic.action.utils.jdbcutil.JdbcUtil;
import web.logic.exception.StoreException;
import web.logic.exception.StoreExistException;
import web.logic.exception.StoreNotExistException;
import web.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * DbStore.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/13/2020
 */
public final class DbStore implements Store<User> {
    /**
     * field a source dbcp2.
     */
    private static final BasicDataSource SOURCE = new BasicDataSource();
    /**
     * field a db store.
     */
    private static final DbStore DB_STORE = new DbStore();
    /**
     * field the path prop file.
     */
    private static final String PROPS = "jdbc.properties";
    /**
     * field the path prop file.
     */
    private static final String SCHEMA = "secret.top.sql";

    /**
     * Constructor.
     */
    private DbStore() {
        final Properties props = JdbcUtil.getProperties(PROPS);
        SOURCE.setUrl(props.getProperty("url"));
        SOURCE.setUsername(props.getProperty("username"));
        SOURCE.setPassword(props.getProperty("password"));
        SOURCE.setMaxIdle(Integer.parseInt(props.getProperty("max")));
        SOURCE.setMinIdle(Integer.parseInt(props.getProperty("min")));
        SOURCE.setMaxOpenPreparedStatements(
                Integer.parseInt(props.getProperty("maxState")));
        SOURCE.setDriverClassName(props.getProperty("driver-class-name"));
        final String sql = JdbcUtil.getSqlCreateTable(SCHEMA);
        JdbcUtil.createTable(sql, SOURCE);
    }

    /**
     * Method to get.
     *
     * @return Db Store
     */
    public static DbStore getInstance() {
        return DB_STORE;
    }

    @Override
    public void add(final User user) {
        final String query = "INSERT INTO top("
                + "time_secret, name_secret, login_secret, email_secret, "
                + "byte_secret)" + " VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = SOURCE.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
            try {
                conn.setAutoCommit(false);
                this.setPst(user, pst, "add");
                pst.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw new StoreExistException(user.getId());
            }
        } catch (SQLException e) {
            throw new StoreException(e.getMessage());
        }
    }

    @Override
    public void update(final User user) {
        final String query = "UPDATE top SET"
                + " time_secret=?, name_secret=?, login_secret=?,"
                + " email_secret=? WHERE id_secret=?";
        try (Connection conn = SOURCE.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
            try {
                conn.setAutoCommit(false);
                this.setPst(user, pst, "update");
                if (pst.executeUpdate() != 1) {
                    throw new StoreNotExistException(user.getId());
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw new StoreNotExistException(user.getId());
            }
        } catch (SQLException e) {
            throw new StoreException(e.getMessage());
        }
    }

    @Override
    public void delete(final User user) {
        final String query = "DELETE FROM top WHERE id_secret=?";
        try (Connection conn = SOURCE.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setInt(1, user.getId());
            if (pst.executeUpdate() == 0) {
                throw new StoreNotExistException(user.getId());
            }
        } catch (SQLException e) {
            throw new StoreException(e.getMessage());
        }

    }

    @Override
    public List<User> findAll() {
        final ArrayList<User> users = new ArrayList<>();
        final String query = "SELECT * FROM top";
        try (Connection conn = SOURCE.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
            final ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id_secret"),
                        rs.getString("time_secret"),
                        rs.getString("name_secret"),
                        rs.getString("login_secret"),
                        rs.getString("email_secret"),
                        rs.getBytes("byte_secret"))
                );
            }
        } catch (SQLException e) {
            throw new StoreException(e.getMessage());
        }
        return users;
    }

    @Override
    public User findById(final int id) {
        final String query = "SELECT time_secret, name_secret, login_secret,"
                + " email_secret, byte_secret FROM top WHERE id_secret=?";
        User user;
        try (Connection conn = SOURCE.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setInt(1, id);
            final ResultSet rs = pst.executeQuery();
            if (!rs.next()) {
                throw new StoreNotExistException(id);
            }
            user = new User(id,
                    rs.getString("time_secret"),
                    rs.getString("name_secret"),
                    rs.getString("login_secret"),
                    rs.getString("email_secret"),
                    rs.getBytes("byte_secret")
            );
        } catch (SQLException e) {
            throw new StoreException(e.getMessage());
        }
        return user;
    }

    @Override
    public void clearStore() {
        final String query = "DELETE FROM top";
        try (Connection conn = SOURCE.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new StoreException(e.getMessage());
        }
    }

    /**
     * Method to set pst.
     *
     * @param user a user
     * @param pst  a prepare statement
     * @param key  a key for choose a act
     * @throws SQLException slq exception
     */
    private void setPst(final User user, final PreparedStatement pst,
                        final String key)
            throws SQLException {
        final int one = 1;
        final int two = 2;
        final int thr = 3;
        final int fou = 4;
        final int fif = 5;
        pst.setString(one, user.getCreateTime());
        pst.setString(two, user.getName());
        pst.setString(thr, user.getLogin());
        pst.setString(fou, user.getEmail());
        switch (key) {
            case "add":
                pst.setBytes(fif, user.getImage());
                break;
            case "update":
                pst.setInt(fif, user.getId());
                break;
            default:
                break;
        }
    }
}
