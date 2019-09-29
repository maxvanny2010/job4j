package parser.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import parser.vacancy.Vacancy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 * Connect.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 9/27/2019
 */
public abstract class DbSore {
    /**
     * field logger.
     */
    private static final Logger LOG = LogManager
            .getLogger(DbSore.class.getName());
    /**
     * field connection to postgres.
     */
    private final Connection connection;


    /**
     * Constructor.
     *
     * @param aConnection a connection to database
     */
    public DbSore(final Connection aConnection) {
        this.connection = aConnection;
    }

    /**
     * Getter.
     *
     * @return connection
     */
    public final Connection getConnection() {
        return this.connection;
    }

    /**
     * Method to get a date last vacancy.
     *
     * @return the date last vacancy or ""
     */
    public abstract String getDateLastVacancy();

    /**
     * Method find vacancy by id.
     *
     * @param id the id of vacancy
     * @return the vacancy
     */
    public abstract Vacancy findVacancyById(int id);

    /**
     * Method drop table in main.
     */
    public final void dropTable() {
        try (PreparedStatement ps = this.connection
                .prepareStatement("DROP TABLE IF EXISTS vacancy")) {
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Method to get data from sql file.
     *
     * @return the data from sql file
     */
    private String getSqlCreateTable() {
        final String schema = "vacancy.sql";
        StringBuilder sb = new StringBuilder();
        try (var in = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(DbSore.class.getClassLoader()
                        .getResourceAsStream(schema))))) {
            in.lines().forEach(sb::append);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return sb.toString();
    }

    /**
     * Method create table in main.
     */
    public final void createTable() {
        try (PreparedStatement ps = this.connection
                .prepareStatement(this.getSqlCreateTable())) {
            ps.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Method add the list of vacancy to database.
     *
     * @param list the list of vacancy
     */
    public final void add(final List<Vacancy> list) {
        if (!list.isEmpty()) {
            for (Vacancy vacancy : list) {
                try (PreparedStatement pst = this.connection.prepareStatement(
                        "INSERT INTO vacancy (date_vacancy,"
                                + "name_vacancy, desc_vacancy, link_vacancy)"
                                + " VALUES (?,?,?,?)")) {
                    final int one = 1;
                    final int two = 2;
                    final int three = 3;
                    final int four = 4;
                    pst.setString(one, vacancy.getDate());
                    pst.setString(two, vacancy.getName());
                    pst.setString(three, vacancy.getDescription());
                    pst.setString(four, vacancy.getLink());
                    pst.execute();
                } catch (SQLException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * Method to get last id of the vacancy.
     *
     * @return the last id of the vacancy
     */
    public final int getCountRowOfVacancy() {
        int rows = -1;
        try (PreparedStatement ps = this.connection
                .prepareStatement("SELECT COUNT(*) FROM vacancy ")) {
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rows = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return rows;
    }

    /**
     * Method to close the database connection.
     */
    public final void closeDB() {
        if (this.connection == null) {
            return;
        }
        try {
            this.connection.close();
        } catch (SQLException e) {
            LOG.error("Connection to database don't close", e);
        }
    }
}
