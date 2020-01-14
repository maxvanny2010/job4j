package delay;

import java.util.concurrent.DelayQueue;

/**
 * DelayCustomer.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/14/2020
 */
class DelayCustomer implements Runnable {
    /**
     * field a queue.
     */
    private final DelayQueue<DelayTask> queue;

    /**
     * Constructor.
     *
     * @param aQueue a queue
     */
    DelayCustomer(final DelayQueue<DelayTask> aQueue) {
        this.queue = aQueue;
    }

    @Override
    public final void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                this.queue.take().run();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Finish Consumer");
    }
}
