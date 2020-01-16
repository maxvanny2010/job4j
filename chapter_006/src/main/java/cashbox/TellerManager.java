package cashbox;

import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * TellerManager.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/16/2020
 */
class TellerManager implements Runnable {
    /**
     * field a counter.
     */
    private final ExecutorService exec;
    /**
     * field a counter.
     */
    private final CustomerLine customers;
    /**
     * field a counter.
     */
    private final PriorityQueue<Teller> workingTellers = new PriorityQueue<>();
    /**
     * field a counter.
     */
    private final Queue<Teller> relaxTellers = new LinkedList<>();
    /**
     * field a counter.
     */
    private final int adjustPeriod;

    /**
     * Constructor.
     *
     * @param aExec         a executor
     * @param aCustomers    a customer
     * @param aAdjustPeriod a period
     */
    TellerManager(final ExecutorService aExec,
                  final CustomerLine aCustomers,
                  final int aAdjustPeriod) {
        this.exec = aExec;
        this.customers = aCustomers;
        this.adjustPeriod = aAdjustPeriod;
        final Teller teller = new Teller(this.customers);
        this.exec.execute(teller);
        this.workingTellers.add(teller);
    }

    /**
     * Method to check and react by a state of queue.
     **/
    final void adjustTellerNumber() {
        if (this.customers.size() / this.workingTellers.size() > 2) {
            if (this.relaxTellers.size() > 0) {
                final Teller teller = this.relaxTellers.remove();
                teller.serveCustomerLine();
                this.workingTellers.offer(teller);
                return;
            }
            Teller teller = new Teller(this.customers);
            this.exec.execute(teller);
            this.workingTellers.add(teller);
            return;
        }
        if (this.workingTellers.size() > 1
                && this.customers.size() / this.workingTellers.size() < 2) {
            this.reassignOneTeller();
        }
        if (this.customers.size() == 0) {
            while (this.workingTellers.size() > 1) {
                this.reassignOneTeller();
            }
        }
    }

    /**
     * Method to add a teller for relax.
     */
    private void reassignOneTeller() {
        final Teller teller = this.workingTellers.poll();
        Objects.requireNonNull(teller).relax();
        this.relaxTellers.offer(teller);
    }

    @Override
    public final void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                TimeUnit.MILLISECONDS.sleep(this.adjustPeriod);
                this.adjustTellerNumber();
                System.out.printf(" %s { ", this.customers);
                this.workingTellers.forEach(
                        teller -> System.out.printf(
                                "%s  ", teller.shortString()));
                System.out.println("}");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Teller manager is terminated");
    }

    @Override
    public final String toString() {
        return TellerManager.class.getSimpleName();
    }
}
