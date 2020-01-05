package counter;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Count.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 12/26/2019
 */
@ThreadSafe
class Count {
    /**
     * field value.
     */
    @GuardedBy("this")
    private int value;

    /**
     * Method to increment.
     */
    final synchronized void increment() {
        this.value++;
    }

    /**
     * Method to get.
     *
     * @return value
     */
    final synchronized int get() {
        return this.value;
    }
}
