package web.logic.action.utils.actionutil;

import web.logic.action.Action;
import web.logic.exception.StoreException;

import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * PropUtil.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/21/2020
 */
public final class PropUtil {
    /**
     * Constructor.
     */
    private PropUtil() {
    }

    /**
     * Method to get.
     *
     * @param schema a schema
     * @return a resource as stream
     */
    private static InputStream getAdminResource(final String schema) {
        return Action.class.getClassLoader().getResourceAsStream(schema);
    }

    /**
     * Method to get.
     *
     * @param file a file of properties
     * @return properties from a file
     */
    public static Properties getProperties(final String file) {
        try (InputStream is = PropUtil.getAdminResource(file)) {
            Properties props = new Properties();
            props.load(Objects.requireNonNull(is));
            return props;
        } catch (Exception e) {
            throw new StoreException("Invalid config file: " + file);
        }
    }

    /**
     * Method to get.
     *
     * @param login    a admin login
     * @param password a admin password
     * @param file     a file with admin credential
     * @return properties from a file
     */
    public static boolean findAdminBy(final String login,
                                      final String password,
                                      final String file) {
        final Properties props = PropUtil.getProperties(file);
        final String adminLogin = props.getProperty("login");
        final String adminPassword = props.getProperty("password");
        return adminLogin.equals(login) && adminPassword.equals(password);
    }
}
