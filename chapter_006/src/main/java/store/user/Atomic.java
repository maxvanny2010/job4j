package store.user;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomic.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 12/29/2019
 */
final class Atomic {
    /**
     * Constructor.
     */
    private Atomic() {
    }

    /**
     * field autoincrement.
     */
    static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();
}
