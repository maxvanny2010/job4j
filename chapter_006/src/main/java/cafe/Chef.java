package cafe;

import java.util.concurrent.TimeUnit;

/**
 * Chef.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/12/2020
 */
class Chef implements Runnable {
    /**
     * field a count.
     */
    private static int count = 0;
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
    Chef(final Cafe aCafe) {
        this.cafe = aCafe;
        final int id = count++;
        this.name = this.getClass().getSimpleName() + id;
    }

    @Override
    public final void run() {
        final int timeout = 50;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                final Order order = this.cafe.getOrders().take();
                System.out.printf("%s CHEF TAKE ORDER\n", this.name);
                final String[] composition = order.getFood().getComposition();
                TimeUnit.MILLISECONDS.sleep(Util.nextInt(timeout));
                final Plate plate = new Plate(order, new Food(composition));
                System.out.printf("%s CHEF DONE %s\n", this.name, plate);
                order.getWaiter().getFillOrders().put(plate);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.printf("%s OFF\n", this.name);
        }
    }

    @Override
    public final String toString() {
        return this.name;
    }
}
