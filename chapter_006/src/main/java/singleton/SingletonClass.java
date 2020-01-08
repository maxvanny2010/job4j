package singleton;

/**
 * TrackerSingle.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/3/2020
 */
final class SingletonClass {
    /**
     * Constructor.
     */
    private SingletonClass() {
    }

    /**
     * Method to get.
     *
     * @return a singleton instance
     */
    static SingletonClass getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * Holder.
     *
     * @author Maxim Vanny
     * @version 1.0
     */
    private static final class Holder {
        /**
         * field instance.
         */
        private static final SingletonClass INSTANCE = new SingletonClass();
    }
}
