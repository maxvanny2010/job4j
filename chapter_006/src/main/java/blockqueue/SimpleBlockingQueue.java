package blockqueue;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * SimpleBlockingQueue.
 *
 * @param <T> type
 * @author Maxim Vanny
 * @version 5.0
 * @since 12/29/2019
 */
@ThreadSafe
class SimpleBlockingQueue<T> {
    /**
     * field queue.
     */
    @GuardedBy("queue")
    private final Queue<T> queue = new LinkedList<>();
    /**
     * field capacity.
     */
    private final int capacity;

    /**
     * Constructor.
     *
     * @param aCapacity capacity
     */
    SimpleBlockingQueue(final int aCapacity) {
        this.capacity = aCapacity;
    }

    /**
     * Method to offer.
     *
     * @param value value
     * @throws InterruptedException InterruptedException
     */
    final void offer(final T value) throws InterruptedException {
        synchronized (this.queue) {
            while (this.queue.size() > this.capacity) {
                final int millis = 5;
                this.queue.wait(millis);
            }
            this.queue.offer(value);
            this.queue.notify();
        }
    }

    /**
     * Method to poll.
     *
     * @return value
     *
     * @throws InterruptedException InterruptedException
     */
    final T poll() throws InterruptedException {
        synchronized (this.queue) {
            while (this.queue.isEmpty()) {
                this.queue.wait();
            }
            final T poll = this.queue.poll();
            this.queue.notify();
            return poll;
        }
    }

    /**
     * Method to get size.
     *
     * @return the size of queue
     */

    final int size() {
        synchronized (this.queue) {
            return this.queue.size();
        }
    }
}
