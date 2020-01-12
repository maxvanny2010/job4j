package cafe;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * WaitPerson.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/12/2020
 */
class Waiter implements Runnable {
    /**
     * field a counter.
     */
    private static int counter = 0;
    /**
     * field a queue of filled orders.
     */
    private final BlockingQueue<Plate> fillOrders = new LinkedBlockingDeque<>();
    /**
     * field a cafe.
     */
    private final Cafe cafe;
    /**
     * field a name.
     */
    private final String name;

    /**
     * Constructor.
     *
     * @param aCafe a cafe
     */
    Waiter(final Cafe aCafe) {
        this.cafe = aCafe;
        final int id = counter++;
        this.name = this.getClass().getSimpleName() + id;
    }

    /**
     * Method to place order in a queue cafe.
     *
     * @param customer a customer
     * @param food     a food
     */
    final void placeOrder(final Customer customer, final Food food) {
        try {
            this.cafe.getOrders().put(new Order(customer, this, food));
            System.out.printf("%s PUT ORDER TO CAFE\n", this.name);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public final void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                final Plate plate = this.fillOrders.take();
                System.out.printf("%s TAKE ORDER %s\n", this.name, plate);
                System.out.printf("%s SET DELIVER %s\n", this.name, plate);
                plate.getOrder().getCustomer().deliver(plate);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.printf("%s OFF", this.name);
    }

    @Override
    public final String toString() {
        return this.name;
    }

    /**
     * Method to get.
     *
     * @return a filled orders
     */
    final BlockingQueue<Plate> getFillOrders() {
        return this.fillOrders;
    }
}
