package parser;

import org.junit.Before;
import org.junit.Test;
import parser.config.Config;
import parser.database.DbSore;
import parser.database.DbSqlite;
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


public class SqliteTest {
    private DbSore sqlite;
    private SchedulerSql scheduler;

    private String getCommandLine() {
        return new StringBuilder()
                .append("java -jar cron.jar app.properties")
                .toString();
    }

    @Before
    public void setBefore() {
        final String[] args = this.getCommandLine().split(" ");
        Config.setParam(args);
        Config.setConfig(new DbSqlite(init("l")), "java", "script");
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setErr(new PrintStream(bos));
        this.scheduler = new SchedulerSql();
        this.sqlite = Config.getDatabase();
        final var time = this.scheduler.getTimeScheduler();
        this.scheduler.getSchedulerStartDefault(time);
    }

    public void someCodeSqliteBefore() {
        this.sqlite.dropTable();
        this.sqlite.createTable();
    }

    @Test
    public void whenAddToSqliteAndGeFirstId() throws InterruptedException {
        this.someCodeSqliteBefore();
        Thread.sleep(100000);
        final int id = 1;
        Vacancy vacancy = this.sqlite.findVacancyById(id);
        assertThat(Objects.requireNonNull(vacancy).toString(),
                is(new StringJoiner(System.lineSeparator())
                        .add("id='" + id + "'")
                        .add("date='04 янв 19, 10:04'")
                        .add("name='Ищем Java-разработчика'")
                        .add("desc='Крупная компания ище'")
                        .add("link='https://www.sql.ru/forum/1307410/ishhem-java-razrabotchika?hl=java'")
                        .toString()));
        this.scheduler.getSchedulerShutDown();
        this.sqlite.closeDB();
    }

    @Test
    public void whenAddToSqliteAndGetCountRowInTable()
            throws InterruptedException {
        this.someCodeSqliteBefore();
        Thread.sleep(80000);
        var result = this.sqlite.getCountRowOfVacancy();
        Thread.sleep(80000);
        var expected = this.sqlite.getCountRowOfVacancy();
        assertEquals(result, expected);
        this.scheduler.getSchedulerShutDown();
        this.sqlite.closeDB();
    }
}
