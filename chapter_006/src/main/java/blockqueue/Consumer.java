package blockqueue;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Consumer.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 12/29/2019
 */
class Consumer implements Runnable {
    /**
     * field buffer.
     */
    private final List<Integer> buffer = new CopyOnWriteArrayList<>();

    /**
     * field queue.
     */
    private final SimpleBlockingQueue<Integer> queue;

    /**
     * Constructor.
     *
     * @param aQueue queue
     */
    Consumer(final SimpleBlockingQueue<Integer> aQueue) {
        this.queue = aQueue;
    }

    @Override
    public final void run() {
        while (this.queue.size() != 0
                || !Thread.currentThread().isInterrupted()) {
            try {
                this.buffer.add(this.queue.poll());
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Method to get.
     *
     * @return buffer
     */
    final List<Integer> getBuffer() {
        return this.buffer;
    }
}
