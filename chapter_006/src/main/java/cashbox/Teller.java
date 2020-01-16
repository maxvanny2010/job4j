package cashbox;

import java.util.concurrent.TimeUnit;

/**
 * Teller.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/16/2020
 */
class Teller implements Runnable, Comparable<Teller> {
    /**
     * field a counter.
     */
    private static int counter = 0;
    /**
     * field a id.
     */
    private final int id = counter++;
    /**
     * field a queue of customers.
     */
    private final CustomerLine customers;
    /**
     * field a count of served customers.
     */
    private int customerServedBySession = 0;
    /**
     * field a state queue.
     */
    private boolean servingCustomerLine = true;

    /**
     * Constructor.
     *
     * @param aCustomers a customers queue
     */
    Teller(final CustomerLine aCustomers) {
        this.customers = aCustomers;
    }

    /**
     * Method when teller to do a something else.
     */
    final synchronized void relax() {
        this.customerServedBySession = 0;
        this.servingCustomerLine = false;
    }

    /**
     * Method to set a serving customer line.
     */
    final synchronized void serveCustomerLine() {
        assert !servingCustomerLine : "already serving: " + this;
        this.servingCustomerLine = true;
        notifyAll();
    }

    @Override
    public final int compareTo(final Teller other) {
        return Integer.compare(this.customerServedBySession,
                other.customerServedBySession);
    }

    @Override
    public final void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                final Customer customer = this.customers.take();
                TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
                synchronized (this) {
                    while (!this.servingCustomerLine) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.printf("Teller %s  is terminated\n", this.id);
    }

    /**
     * Method to get.
     *
     * @return id
     */
    final String shortString() {
        return "T" + this.id;
    }

    @Override
    public final String toString() {
        return String.format("%s %s", Teller.class.getSimpleName(), this.id);
    }
}
