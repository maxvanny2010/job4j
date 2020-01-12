package cafe;

import java.util.Random;

/**
 * Util.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/12/2020
 */
final class Util {
    /**
     * field a seed.
     */
    public static final int SEED = 47;

    /**
     * Constructor.
     */
    private Util() {
    }

    /**
     * Method to get.
     *
     * @param nInt int
     * @return a random int
     */
    public static int nextInt(final int nInt) {
        return new Random(SEED).nextInt(nInt);
    }
}
