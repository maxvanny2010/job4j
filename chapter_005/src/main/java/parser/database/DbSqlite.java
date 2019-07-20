package parser.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import parser.vacancy.Vacancy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DbSqlite.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 9/13/2019
 */
public class DbSqlite extends DbSore {
    /**
     * field logger.
     */
    private static final Logger LOG = LogManager
            .getLogger(DbSqlite.class.getName());

    /**
     * Constructor.
     *
     * @param aConnection connection
     */
    public DbSqlite(final Connection aConnection) {
        super(aConnection);
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
                        + " WHERE OID = (SELECT COUNT(*) FROM vacancy)")) {
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
                "SELECT * FROM vacancy WHERE OID =?")) {
            ps.setInt(1, id);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Vacancy(
                        String.valueOf(id),
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
