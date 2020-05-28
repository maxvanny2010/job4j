package ua.nino.logic.action.utils.actionutil;

import ua.nino.logic.action.Action;
import ua.nino.logic.exception.StoreException;

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

}
