package delay;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * DelayTask.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/14/2020
 */
class DelayTask implements Runnable, Delayed {
    /**
     * field a list of delay task.
     */
    private static final List<DelayTask> SEQUENCE = new ArrayList<>();
    /**
     * field a counter for id.
     */
    private static int counter = 0;
    /**
     * field a set id.
     */
    private final int id = counter++;
    /**
     * field a delta that to add to a current time.
     */
    private final int delta;
    /**
     * field a trigger -a time for action.
     */
    private final long trigger;

    /**
     * Constructor.
     *
     * @param delayMilliseconds mills
     */
    DelayTask(final int delayMilliseconds) {
        this.delta = delayMilliseconds;
        this.trigger = System.nanoTime()
                + NANOSECONDS.convert(this.delta, MILLISECONDS);
        SEQUENCE.add(this);
    }

    @Override
    public final int compareTo(@Nonnull final Delayed arg) {
        DelayTask that = (DelayTask) arg;
        return Long.compare(this.trigger, that.trigger);
    }

    @Override
    public final long getDelay(final TimeUnit unit) {
        return unit.convert(
                this.trigger - System.nanoTime(), NANOSECONDS);
    }

    @Override
    public void run() {
        System.out.println(this + " ");
    }

    @Override
    public final String toString() {
        return String.format("[%1$-4d]", this.delta) + " Task " + this.id;
    }

    /**
     * Method to count summary.
     *
     * @return the summary
     */
    public final String summary() {
        return "(" + this.id + ":" + this.delta + ")";
    }

    /**
     * Inner static class.
     */
    static class EndSentinel extends DelayTask {
        /**
         * field a executor.
         */
        private final ExecutorService exec;

        /**
         * Constructor.
         *
         * @param delay a delay for close executor
         * @param aExec the executor
         */
        EndSentinel(final int delay, final ExecutorService aExec) {
            super(delay);
            this.exec = aExec;
        }

        @Override
        public final void run() {
            SEQUENCE.stream()
                    .map(DelayTask::summary)
                    .forEach(System.out::println);
            System.out.printf("%s shutdown\n", this.getClass().getSimpleName());
            this.exec.shutdownNow();
        }

    }
}
