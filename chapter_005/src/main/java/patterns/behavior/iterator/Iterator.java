package patterns.behavior.iterator;

/**
 * Iterator.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/13/2019
 */
public interface Iterator {
    /**
     * Method to check next step.
     *
     * @return the result
     */
    boolean hasNext();

    /**
     * Method to get the next step.
     *
     * @return the next step
     */
    Object next();
}
