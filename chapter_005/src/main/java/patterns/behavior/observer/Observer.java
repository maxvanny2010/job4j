package patterns.behavior.observer;

/**
 * Observer.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/28/2019
 */
interface Observer {
    /**
     * Method to handle the event.
     *
     * @param temp  temp
     * @param press pressure
     */
    void handleEvent(int temp, int press);
}
