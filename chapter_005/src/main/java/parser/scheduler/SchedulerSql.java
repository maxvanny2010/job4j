package parser.scheduler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import parser.config.Config;
import parser.quartz.QuartzSql;
import parser.quartz.QuartzStore;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * SchedulerSql.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 7/16/2019
 */
public class SchedulerSql implements SchedulerStore {
    /**
     * field logger.
     */
    private static final Logger LOG = LogManager
            .getLogger(QuartzStore.class.getName());
    /**
     * field scheduler.
     */
    private Scheduler scheduler;

    /**
     * Method to get time for scheduler.
     *
     * @return atime for scheduler.
     */
    @Override
    public final String getTimeScheduler() {
        final String param = Config.getParam();
        try (InputStream is = QuartzSql.class.getClassLoader()
                .getResourceAsStream(param)) {
            final Properties props = new Properties();
            props.load(Objects.requireNonNull(is));
            return props.getProperty("cron.time");
        } catch (IOException e) {
            throw new IllegalStateException("Invalid config file " + param, e);
        }
    }

    /**
     * Method to start the default scheduler.
     *
     * @param time the time to start the scheduler
     */
    @Override
    public final void getSchedulerStartDefault(final String time) {
        try {
            final JobDetail job = newJob(QuartzSql.class)
                    .withIdentity("Quartz")
                    .build();
            final Trigger trigger = newTrigger()
                    .withSchedule(cronSchedule(time))
                    .build();
            this.scheduler = StdSchedulerFactory.
                    getDefaultScheduler();
            this.scheduler.start();
            this.scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Method to shutdown the scheduler.
     */
    @Override
    public final void getSchedulerShutDown() {
        try {
            this.scheduler.shutdown(true);
        } catch (SchedulerException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
