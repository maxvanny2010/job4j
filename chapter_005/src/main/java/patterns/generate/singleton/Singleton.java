package patterns.generate.singleton;

/**
 * Singleton.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/26/2019
 */
final class Singleton {
    /**
     * field instance.
     */
    private static volatile Singleton instance;
    /**
     * field a value.
     */
    private final String value;

    /**
     * Constructor.
     *
     * @param aValue the value
     */
    private Singleton(final String aValue) {
        this.value = aValue;
    }

    /**
     * Method to get instance.
     *
     * @param context a context
     * @return the instance
     */
    static synchronized Singleton getInstance(final String context) {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(context);
                }
            }
        }
        return instance;
    }

    /**
     * Method a getter.
     *
     * @return the value
     */
    public String getValue() {
        return this.value;
    }
}
