package patterns.behavior.observer;

/**
 * Observable.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/28/2019
 */
interface Observable {
    /**
     * Method to add.
     *
     * @param observer observer
     */
    void addObserver(Observer observer);

    /**
     * Method to remove.
     *
     * @param observer observer
     */
    void removeObserver(Observer observer);
}
