package cashbox;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * CustomerLine.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/16/2020
 */
class CustomerLine extends ArrayBlockingQueue<Customer> {
    /**
     * Constructor.
     *
     * @param capacity a capacity
     */
    CustomerLine(final int capacity) {
        super(capacity);
    }

    @Override
    public final String toString() {
        if (this.size() == 0) {
            return "[Empty]";
        }
        final StringBuilder result = new StringBuilder();
        this.forEach(result::append);
        return result.toString();
    }
}
