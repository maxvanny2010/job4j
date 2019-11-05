package patterns.behavior.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Broker.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/28/2019
 */
class Broker {
    /**
     * field list.
     */
    private final List<Order> list = new ArrayList<>();

    /**
     * Method to take the order.
     *
     * @param order the order
     */
    final void takeOrder(final Order order) {
        this.list.add(order);
    }

    /**
     * Method to place the order.
     */
    final void placeOrder() {
        for (final Order order : this.list) {
            order.execute();
        }
        this.list.clear();
    }

}
