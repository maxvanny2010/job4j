package web.logic.action.utils.jdbcutil;

import org.apache.commons.dbcp2.BasicDataSource;
import web.logic.exception.StoreException;
import web.persistent.DbStore;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

/**
 * JdbcUtil.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/14/2020
 */
public final class JdbcUtil {
    /**
     * Constructor.
     */
    private JdbcUtil() {
    }

    /**
     * Method to get.
     *
     * @param schema a schema
     * @return a slq query
     */
    public static String getSqlCreateTable(final String schema) {
        final var bos = new ByteArrayOutputStream();
        final var size = 1024;
        final var buffer = new byte[size];
        int length;
        try (var is = Objects.requireNonNull(JdbcUtil.getResource(schema))) {
            while ((length = is.read(buffer)) != -1) {
                bos.write(buffer, 0, length);
            }
        } catch (IOException e) {
            throw new StoreException(e.getMessage());
        }
        return bos.toString(StandardCharsets.UTF_8);
    }

    /**
     * Method to create.
     *
     * @param source a source
     * @param sql    a slq query
     **/
    public static void createTable(final String sql,
                                   final BasicDataSource source) {
        try (Connection conn = source.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new StoreException(e.getMessage());
        }
    }

    /**
     * Method to get.
     *
     * @param schema a schema
     * @return a resource as stream
     */
    private static InputStream getResource(final String schema) {
        return DbStore.class.getClassLoader().getResourceAsStream(schema);
    }

    /**
     * Method to get.
     *
     * @param file a file of properties
     * @return properties from a file
     */
    public static Properties getProperties(final String file) {
        try (InputStream is = JdbcUtil.getResource(file)) {
            Properties props = new Properties();
            props.load(Objects.requireNonNull(is));
            return props;
        } catch (Exception e) {
            throw new StoreException("Invalid config file: " + file);
        }
    }
}
