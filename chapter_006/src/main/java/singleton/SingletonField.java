package singleton;

/**
 * SingletonField.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/3/2020
 */
final class SingletonField {
    /**
     * field instance.
     */
    private static final SingletonField INSTANCE = new SingletonField();

    /**
     * Constructor.
     */
    private SingletonField() {
    }

    /**
     * Method to get.
     *
     * @return a singleton instance
     */
    static SingletonField getInstance() {
        return INSTANCE;
    }

}
