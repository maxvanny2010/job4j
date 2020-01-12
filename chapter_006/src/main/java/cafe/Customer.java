package cafe;

import javax.annotation.Nonnull;
import java.util.concurrent.SynchronousQueue;

/**
 * Costumer.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/12/2020
 */
class Customer implements Runnable {
    /**
     * field a counter.
     */
    private static int counter = 0;
    /**
     * field a plates.
     */
    private final SynchronousQueue<Plate> plates = new SynchronousQueue<>();
    /**
     * field a waiter.
     */
    private final Waiter waiter;
    /**
     * field a name.
     */
    private final String name;

    /**
     * Consumer.
     *
     * @param aWaiter a waiter
     */
    Customer(final Waiter aWaiter) {
        this.waiter = aWaiter;
        final int id = counter++;
        this.name = this.getClass().getSimpleName() + id;
    }

    /**
     * Method to set a plate deliver.
     *
     * @param plate plate
     * @throws InterruptedException InterruptedException
     **/
    final void deliver(@Nonnull final Plate plate) throws InterruptedException {
        System.out.printf("%s GET DELIVER %s\n", this.name, plate);
        this.plates.put(plate);
    }

    @Override
    public final void run() {
        for (Menu menu : Menu.values()) {
            try {
                final Food food = menu.randomSelection();
                System.out.printf("%s PLACE ORDER\n", this.name);
                this.waiter.placeOrder(this, food);
                final Plate plate = this.plates.take();
                System.out.printf("%s EATING %s\n", this.name, plate);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%s FINISH MEAL", this.name);
    }

    @Override
    public final String toString() {
        return this.name;
    }
}
