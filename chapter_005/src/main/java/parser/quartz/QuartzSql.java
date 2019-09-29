package parser.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import parser.config.Config;
import parser.vacancy.VacancyList;

import java.util.Date;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * QuartzSql.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 7/19/2019
 */
public class QuartzSql implements QuartzStore, Job {
    /**
     * field Parser.
     */
    private final ParserSql parser = new ParserSql();
    /**
     * field list.
     */
    private final VacancyList list = new VacancyList();

    /**
     * Constructor.
     */
    public QuartzSql() {
    }

    @Override
    public final void execute(final JobExecutionContext jobExecutionContext) {
        final Date fire = jobExecutionContext.getFireTime();
        this.startParser(fire);
        Config.getDatabase().add(this.list.getList());
        this.list.clear();
    }

    /**
     * Method to start the parser and to write new data to database.
     *
     * @param fire the date of last vacancy in the database
     */
    private void startParser(final Date fire) {
        if (fire != null) {
            this.getData(this::isCheckStartYear);
        } else {
            this.getData(this::isCheckSameData);
        }
    }

    /**
     * Method to get data from the site.
     *
     * @param isChecker a supplier to check a date  from
     *                  a start year and the same date
     */
    private void getData(final Supplier<Boolean> isChecker) {
        final String url = this.parser.getBaseLink();
        var page = 1;
        final var code = 200;
        boolean check = false;
        while (this.parser.connPage(url + page).statusCode() == code
                && !check) {
            check = isChecker.get();
            page++;
        }
    }


    /**
     * Method to get vacancy from 2019 year.
     *
     * @return trigger check
     */
    private Boolean isCheckStartYear() {
        final var inPage = 50;
        boolean check = false;
        for (int index = 0; index < inPage; index++) {
            final var date = this.parser.getDate(index);
            if (!date.contains("19,")) {
                check = true;
                break;
            } else {
                if (getOnlyJava(this.parser, index)) {
                    this.list.add(
                            createVacancy(this.parser, index, date)
                    );
                }
            }
        }
        return check;
    }

    /**
     * Method to get vacancy from 2019 year.
     *
     * @return trigger check
     */
    private boolean isCheckSameData() {
        final var inPage = 50;
        final String[] date = {""};
        final var lastDate = Config.getDatabase().getDateLastVacancy();
        IntStream.range(0, inPage)
                .peek(i -> date[0] = this.parser.getDate(i))
                .takeWhile(i -> !lastDate.equals(date[0]))
                .forEach(i -> {
                    if (getOnlyJava(parser, i)) {
                        this.list.add(
                                createVacancy(this.parser, i, date[0])
                        );
                    }
                });
        return true;
    }
}
