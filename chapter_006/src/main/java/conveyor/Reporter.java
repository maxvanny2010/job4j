package conveyor;

/**
 * Reporter.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/11/2020
 */
class Reporter implements Runnable {
    /**
     * field a queue.
     */
    private final CarQueue carQueue;

    /**
     * Constructor.
     *
     * @param aCarQueue a queue
     */
    Reporter(final CarQueue aCarQueue) {
        this.carQueue = aCarQueue;
    }

    @Override
    public final void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(this.carQueue.take());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Reporter off ");
    }
}
