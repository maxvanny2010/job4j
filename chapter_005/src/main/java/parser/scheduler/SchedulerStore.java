package parser.scheduler;

/**
 * SchedulerStore.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 9/16/2019
 */
@SuppressWarnings("unused")
public interface SchedulerStore {
    /**
     * Method to get time for scheduler.
     *
     * @return atime for scheduler.
     */
    String getTimeScheduler();

    /**
     * Method to start the default scheduler.
     *
     * @param time the time to start the scheduler
     */
    void getSchedulerStartDefault(String time);

    /**
     * Method to shutdown the scheduler.
     */
    void getSchedulerShutDown();
}
