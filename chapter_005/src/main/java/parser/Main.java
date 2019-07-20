package parser;

import parser.config.Config;
import parser.database.DbPostgres;
import parser.database.DbSore;
import parser.scheduler.SchedulerSql;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static parser.config.Config.init;

/**
 * Main.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 7/23/2019
 */
public final class Main {
    /**
     * Constructor.
     */
    private Main() {
    }

    /**
     * Point enter to program.
     *
     * @param args array command args[0] app.properties.
     * @throws InterruptedException InterruptedException
     */
    public static void main(final String[] args) throws InterruptedException {
        final String[] s = "java -jar cron.jar app.properties".split(" ");
        Config.setParam(s);
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setErr(new PrintStream(bos));
        final SchedulerSql scheduler = new SchedulerSql();
        Config.setConfig(new DbPostgres(init("p")),
                "java", "script");
        final DbSore db = Config.getDatabase();
        db.createTable();
        final String time = scheduler.getTimeScheduler();
        scheduler.getSchedulerStartDefault(time);
        final int millis = 80000;
        Thread.sleep(millis);
        final int rows = db.getCountRowOfVacancy();
        final int id = 1;
        if (rows != -1) {
            System.out.println("First vacancy: ");
            System.out.println(db.findVacancyById(id));
        } else {
            System.out.println("db is empty");
        }
    }
}
