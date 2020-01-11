package cash;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomic.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/1/2020
 */
final class Atomic {
    /**
     * field autoincrement.
     **/
    private static AtomicInteger ai = new AtomicInteger();

    /**
     * Constructor.
     */
    private Atomic() {
    }

    /**
     * Method to get.
     *
     * @return atomic integer
     **/
    static AtomicInteger getAtomicInteger() {
        return ai;
    }

    /**
     * Method to set.
     *
     * @param aAi atomic
     */
    static void setAi(final AtomicInteger aAi) {
        Atomic.ai = aAi;
    }
}
