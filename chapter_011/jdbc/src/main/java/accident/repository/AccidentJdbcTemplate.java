package accident.repository;

import accident.model.Accident;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AccidentJdbcTemplate.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/4/2020
 */
@Repository
public class AccidentJdbcTemplate implements IAccidentRepository {
    /**
     * field a jdbc.
     */
    private final JdbcTemplate jdbc;

    /**
     * Constructor.
     *
     * @param aJdbc a jdbc
     */
    public AccidentJdbcTemplate(final JdbcTemplate aJdbc) {
        this.jdbc = aJdbc;
    }

    @Override
    public final Accident save(final Accident accident) {
        this.jdbc.update("INSERT INTO accident(name) values (?)",
                accident.getName());
        return accident;
    }

    @Override
    public final Accident edit(final Accident accident) {
        this.jdbc.update("UPDATE accident SET name= ? WHERE id_accident= ?",
                accident.getName(), accident.getId());
        return accident;
    }

    @Override
    public final Accident delete(final Accident accident) {
        this.jdbc.update("DELETE FROM accident  WHERE id_accident=?",
                accident.getId());
        return accident;
    }

    @Override
    public final Accident get(final Accident value) {
        return this.jdbc.queryForObject(
                "SELECT DISTINCT id_accident, name"
                        + " FROM accident WHERE id_accident= ?",
                (rs, row) -> {
                    final Accident accident = new Accident();
                    accident.setId(rs.getInt("id_accident"));
                    accident.setName(rs.getString("name"));
                    return accident;
                }, value.getId());
    }

    @Override
    public final List<Accident> getAll() {
        return jdbc.query("SELECT id_accident, name FROM accident",
                (rs, row) -> {
                    final Accident accident = new Accident();
                    accident.setId(rs.getInt("id_accident"));
                    accident.setName(rs.getString("name"));
                    return accident;
                });
    }
}
