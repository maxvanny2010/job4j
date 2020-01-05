package parser;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import parser.config.Config;
import parser.database.DbPostgres;
import parser.database.DbSore;
import parser.scheduler.SchedulerSql;
import parser.vacancy.Vacancy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Objects;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static parser.config.Config.init;


public class PostgresTest {
    private DbSore postgres;
    private SchedulerSql scheduler;

    private String getCommandLine() {
        return new StringBuilder()
                .append("java -jar cron.jar app.properties")
                .toString();
    }

    @Ignore
    @Before
    public void setBefore() {
        final String[] args = this.getCommandLine().split(" ");
        Config.setParam(args);
        Config.setConfig(new DbPostgres(init("p")), "java", "script");
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setErr(new PrintStream(bos));
        this.scheduler = new SchedulerSql();
        this.postgres = Config.getDatabase();
        final var time = scheduler.getTimeScheduler();
        scheduler.getSchedulerStartDefault(time);
    }

    @Ignore
    private void someCodePostgresBefore() {
        this.postgres.dropTable();
        this.postgres.createTable();
    }

    @Ignore
    @Test
    public void whenAddToPostgresAndGeFirstId() throws InterruptedException {
        this.someCodePostgresBefore();
        final int millis = 100000;
        Thread.sleep(millis);
        final int id = 1;
        Vacancy vacancy = this.postgres.findVacancyById(id);
        assertThat(Objects.requireNonNull(vacancy).toString(),
                is(new StringJoiner(System.lineSeparator())
                        .add("id='" + id + "'")
                        .add("date='04 янв 19, 10:04'")
                        .add("name='Ищем Java-разработчика'")
                        .add("desc='Крупная компания ище'")
                        .add("link='https://www.sql.ru/forum/1307410/ishhem-java-razrabotchika?hl=java'")
                        .toString()));
        this.scheduler.getSchedulerShutDown();
        this.postgres.closeDB();
    }

    @Ignore
    @Test
    public void whenAddToPostgresAndGetCountRowInTable()
            throws InterruptedException {
        this.someCodePostgresBefore();
        final int millis = 80000;
        Thread.sleep(millis);
        var result = this.postgres.getCountRowOfVacancy();
        Thread.sleep(millis);
        var expected = this.postgres.getCountRowOfVacancy();
        assertEquals(result, expected);
        this.scheduler.getSchedulerShutDown();
        this.postgres.closeDB();
    }
}
