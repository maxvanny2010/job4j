package cafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Cafe.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/12/2020
 */
public class Cafe implements Runnable {
    /**
     * field a waiters.
     */
    private final List<Waiter> waiters = new ArrayList<>();
    /**
     * field a orders.
     */
    private final BlockingQueue<Order> orders = new LinkedBlockingDeque<>();
    /**
     * field a pool.
     */
    private final ExecutorService exec;

    /**
     * Constructor.
     *
     * @param aExec    executor
     * @param nWorkers workers
     */
    public Cafe(final ExecutorService aExec, final int nWorkers) {
        this.exec = aExec;
        final int bound = 3;
        IntStream.range(0, nWorkers).forEach(each -> {
            if (each != 0 && each % bound == 0) {
                final Chef chef = new Chef(this);
                this.exec.execute(chef);
            } else {
                final Waiter waiter = new Waiter(this);
                this.waiters.add(waiter);
                this.exec.execute(waiter);
            }
        });
    }

    /**
     * Method to get.
     *
     * @return a waiters
     */
    final List<Waiter> getWaiters() {
        return this.waiters;
    }

    /**
     * Method to get.
     *
     * @return a orders
     */
    final BlockingQueue<Order> getOrders() {
        return this.orders;
    }

    @Override
    public final void run() {
        final int timeout = 100;
        final int size = this.getWaiters().size();
        try {
            while (!Thread.currentThread().isInterrupted()) {
                final int index = Util.nextInt(size);
                final Waiter waiter = this.waiters.get(index);
                final Customer customer = new Customer(waiter);
                this.exec.execute(customer);
                TimeUnit.MILLISECONDS.sleep(timeout);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Thread.currentThread().interrupt();
        System.out.println("Cafe is closed\n");
    }
}
