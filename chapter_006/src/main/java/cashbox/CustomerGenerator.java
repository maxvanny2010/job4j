package cashbox;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * CustomerGenerator.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/16/2020
 */
class CustomerGenerator implements Runnable {
    /**
     * field a seed.
     */
    private final int seed = 47;
    /**
     * field a random.
     */
    private final Random random = new Random(seed);
    /**
     * field a customers.
     */
    private final CustomerLine customers;

    /**
     * Constructor.
     *
     * @param aCustomers a  array of customers
     */
    CustomerGenerator(final CustomerLine aCustomers) {
        this.customers = aCustomers;
    }

    @Override
    public final void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                final int rise = 6;
                TimeUnit.MILLISECONDS.sleep(random.nextInt(seed * rise));
                this.customers.put(new Customer(
                        random.nextInt(seed * seed * 2)));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Generator is terminated");
    }
}
