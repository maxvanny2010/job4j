package patterns.net.businessdelegate;

/**
 * Client.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/31/2019
 */
class Client {
    /**
     * field delegate.
     */
    private final BusinessDelegate delegate;

    /**
     * Constructor.
     *
     * @param aDelegate delegate
     */
    Client(final BusinessDelegate aDelegate) {
        this.delegate = aDelegate;
    }

    /**
     * Method to do task.
     */
    final void doTask() {
        this.delegate.doTask();
    }
}
