package conveyor;

import java.util.concurrent.TimeUnit;

/**
 * ChassisBuilder.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/11/2020
 */
class ChassisBuilder implements Runnable {
    /**
     * field a queue .
     */
    private final CarQueue carQueue;
    /**
     * field a counter.
     */
    private int counter = 0;

    /**
     * Constructor.
     *
     * @param aCarQueue a queue
     */
    ChassisBuilder(final CarQueue aCarQueue) {
        this.carQueue = aCarQueue;
    }

    @Override
    public final void run() {
        final int timeout = 100;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                TimeUnit.MILLISECONDS.sleep(timeout);
                final Car car = new Car(this.counter++);
                this.carQueue.put(car);
                System.out.printf("Chassis created %s\n", car);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Chassis off");
    }
}
