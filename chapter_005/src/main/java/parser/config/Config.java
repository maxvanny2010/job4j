package parser.config;

import parser.database.DbSore;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

/**
 * Config.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 9/27/2019
 */
public final class Config {
    /**
     * field the arguments of command line.
     */
    private static String[] args;
    /**
     * field the interface StoreDB.
     */
    private static DbSore db;
    /**
     * field the query.
     */
    private static String query;
    /**
     * field the exception string.
     */
    private static String excQuery;

    /**
     * Constructor.
     */
    private Config() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Method to get argument command line.
     *
     * @return argument command line
     */
    public static String getParam() {
        final int index = 3;
        if (!args[index].equals("app.properties")) {
            throw new IllegalArgumentException("Missing app.properties");
        }
        return args[index];
    }

    /**
     * Method to set arguments from command line to class.
     *
     * @param aArgs arguments from command line
     */
    public static void setParam(final String[] aArgs) {
        args = aArgs;
    }

    /**
     * Method to set config the app.
     *
     * @param aDb       a database
     * @param aQuery    a query
     * @param aExcQuery a exception string in query
     */
    public static void setConfig(final DbSore aDb,
                                 final String aQuery,
                                 final String aExcQuery) {
        Objects.requireNonNull(aDb, "must not be null");
        Objects.requireNonNull(aQuery, "must not be null");
        Objects.requireNonNull(aExcQuery, "must not be null");
        db = aDb;
        query = aQuery;
        excQuery = aExcQuery;

    }

    /**
     * Method to get database.
     *
     * @return database
     */
    public static DbSore getDatabase() {
        return db;
    }

    /**
     * Method to get query.
     *
     * @return the query
     */
    public static String getQuery() {
        return query;
    }

    /**
     * Method to get a exception world in the query.
     *
     * @return the exception world in the query
     */
    public static String getExcQuery() {
        return excQuery;
    }

    /**
     * Method get and set connection to postgres.
     *
     * @param key a key to choice database url
     * @return the data of connection
     */
    public static Connection init(final String key) {
        Objects.requireNonNull(key, "must not by null");
        final var url = getProps(key);
        final var param = Config.getParam();
        try (InputStream is = DbSore.class.
                getClassLoader().
                getResourceAsStream(param)) {
            Properties props = new Properties();
            props.load(Objects.requireNonNull(is));
            return DriverManager.getConnection(
                    props.getProperty(url[0]),
                    props.getProperty(url[1]),
                    props.getProperty(url[2])
            );
        } catch (IOException | SQLException e) {
            throw new IllegalStateException("Invalid config file " + param, e);
        }
    }

    /**
     * Method to get right url for connect.
     *
     * @param key a key to choice database url
     * @return url
     */
    private static String[] getProps(final String key) {
        String[] url = new String[3];
        if (key.equals("p")) {
            url[0] = "url";
            url[1] = "username";
            url[2] = "password";
        } else if (key.equals("l")) {
            url[0] = "sql_url";
            url[1] = "sql_username";
            url[2] = "sql_password";
        } else {
            throw new IllegalArgumentException("Key must be \"p\" or \"s\"");
        }
        return url;
    }
}
