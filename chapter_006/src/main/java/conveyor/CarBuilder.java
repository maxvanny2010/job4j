package conveyor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CarBuilder.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/11/2020
 */
final class CarBuilder {
    /**
     * Constructor.
     */
    private CarBuilder() {
    }

    /**
     * Method to point in program.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        final CarQueue chassisQueue = new CarQueue();
        final CarQueue finishQueue = new CarQueue();
        final RobotPool pool = new RobotPool();
        final ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new RobotEngine(pool));
        exec.execute(new RobotDriveTrain(pool));
        exec.execute(new RobotWheel(pool));
        exec.execute(new Assembler(chassisQueue, finishQueue, pool));
        exec.execute(new Reporter(finishQueue));
        exec.execute(new ChassisBuilder(chassisQueue));
        try {
            final int timeout = 400;
            exec.awaitTermination(timeout, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        exec.shutdownNow();
    }
}
