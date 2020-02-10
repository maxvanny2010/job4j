package web.model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomic.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/29/2020
 */
public final class Atomic {
    /**
     * field autoincrement.
     */
    public static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();

    /**
     * Constructor.
     */
    private Atomic() {
    }
}
