package pool;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * ThreadPool.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/4/2020
 */
class ThreadPool {
    /**
     * field list threads.
     */
    private final List<Thread> threads = new LinkedList<>();
    /**
     * field the tasks of runnable.
     */
    private final BlockingQueue<Runnable> tasks;

    /**
     * Constructor.
     *
     * @param capacity capacity
     */
    ThreadPool(final int capacity) {
        this.tasks = new BlockingQueue<>(capacity);
        final int size = Runtime.getRuntime().availableProcessors();
        IntStream.range(0, size).forEach(i -> this.threads.add(
                new Element(this.tasks)));
    }

    /**
     * Method to start the pool of daemon threads.
     */
    final void startPool() {
        this.threads.forEach(Thread::start);
    }

    /**
     * Method to receive a runnable.
     *
     * @param job job
     */
    final void work(final Runnable job) {
        try {
            this.tasks.offer(job);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Stop ThreadPool engine.
     */
    final void shutdown() {
        this.threads.forEach(Thread::interrupt);
    }

    /**
     * Method to get.
     *
     * @return the list of Threads
     */
    final List<Thread> getListThreads() {
        return this.threads;
    }
}
