package patterns.behavior.iterator;

/**
 * Container.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/13/2019
 */
interface Container {
    /**
     * Method to get the Iterator.
     *
     * @return the Iterator
     */
    Iterator getIterator();
}
