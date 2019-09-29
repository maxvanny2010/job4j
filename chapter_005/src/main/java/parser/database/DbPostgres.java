package parser.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import parser.vacancy.Vacancy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DbPostgres.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 7/12/2019
 */
public class DbPostgres extends DbSore {
    /**
     * field logger.
     */
    private static final Logger LOG = LogManager
            .getLogger(DbPostgres.class.getName());

    /**
     * Constructor.
     *
     * @param connection connection
     */
    public DbPostgres(final Connection connection) {
        super(connection);
    }

    /**
     * Method to check empty or not a vacancy.
     *
     * @return if empty return "", if not to return the last date
     */
    @Override
    public final String getDateLastVacancy() {
        String date = "";
        try (PreparedStatement ps = super.getConnection()
                .prepareStatement("SELECT date_vacancy FROM vacancy"
                        + " WHERE id =(SELECT COUNT(*)FROM vacancy)")) {
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                date = rs.getString("date_vacancy");
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return date;
    }

    /**
     * Method find vacancy by id.
     *
     * @param id the id of vacancy
     * @return the vacancy
     */
    @Override
    public final Vacancy findVacancyById(final int id) {
        try (PreparedStatement ps = super.getConnection().prepareStatement(
                "SELECT * FROM vacancy WHERE  id = ?")) {
            ps.setInt(1, id);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Vacancy(
                        rs.getString("id"),
                        rs.getString("date_vacancy"),
                        rs.getString("name_vacancy"),
                        rs.getString("desc_vacancy"),
                        rs.getString("link_vacancy"));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }
}
