package cafe;

import java.util.StringJoiner;

/**
 * Order.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/12/2020
 */
class Order {
    /**
     * field a counter.
     */
    private static int counter = 0;
    /**
     * field a id.
     */
    private final int id;
    /**
     * field a customer.
     */
    private final Customer customer;
    /**
     * field a waiter.
     */
    private final Waiter waiter;
    /**
     * field a food.
     */
    private final Food food;

    /**
     * Constructor.
     *
     * @param aCustomer a customer
     * @param aWaiter   a waiter
     * @param aFood     a food
     */
    Order(final Customer aCustomer, final Waiter aWaiter, final Food aFood) {
        this.customer = aCustomer;
        this.waiter = aWaiter;
        this.food = aFood;
        this.id = counter++;

    }

    /**
     * Method to get.
     *
     * @return a customer
     */
    final Customer getCustomer() {
        return this.customer;
    }

    /**
     * Method to get.
     *
     * @return a waiter
     */
    final Waiter getWaiter() {
        return this.waiter;
    }

    /**
     * Method to get.
     *
     * @return a food
     */
    final Food getFood() {
        return this.food;
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Order.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("costumer=" + this.customer)
                .add("waitPerson=" + this.waiter)
                .add("food=" + this.food)
                .toString();
    }
}
