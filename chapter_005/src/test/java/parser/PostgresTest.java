package parser;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static parser.Postgres.init;


public class PostgresTest {
    private Postgres postgres;
    private SchedulerParser scheduler;
    private final SetVacancies setVacancies = new SetVacancies();
    private Set<Vacancy> set;

    private String getCommandLine() {
        return new StringBuilder()
                .append("java -jar cron.jar app.properties")
                .toString();
    }

    @Before
    public void setBefore() throws InterruptedException {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setErr(new PrintStream(bos));
        final String[] args = this.getCommandLine().split(" ");
        this.scheduler = new SchedulerParser(args);
        this.postgres = new Postgres(init());
        this.postgres.dropTable();
        this.postgres.createTable();
        final var time = this.scheduler.getTimeScheduler();
        this.scheduler.getSchedulerStartDefault(time);
        Thread.sleep(60000);
        this.set = this.setVacancies.getSet();
        if (this.set != null) {
            this.postgres.add(this.set);
        }
    }

    @Test
    public void whenAddToSqlAndGeFirstId() {
        Vacancy vacancy = this.postgres.findVacancyById(this.postgres.getCountRowsInVacancy());
        assertThat(Objects.requireNonNull(vacancy).toString(), is(new StringJoiner(System.lineSeparator())
                .add("id='" + this.postgres.getCountRowsInVacancy() + "'")
                .add("date='04 янв 19, 10:04'")
                .add("name='Ищем Java-разработчика'")
                .add("desc='Крупная компания ище'")
                .add("link='https://www.sql.ru/forum/1307410/ishhem-java-razrabotchika?hl=java'")
                .toString()));
        this.scheduler.getSchedulerShutDown();
        this.postgres.close();
    }

    @Test
    public void whenAddToSqlAndGetCountRowInTable() throws InterruptedException {
        Thread.sleep(60000);
        this.set = this.setVacancies.getSet();
        if (this.set != null) {
            this.postgres.add(this.set);
        }
        assertNotNull(this.set);
        this.scheduler.getSchedulerShutDown();
        this.postgres.close();
    }
}
