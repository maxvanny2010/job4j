package patterns.behavior.mediator;

/**
 * Mediator.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/29/2019
 */
interface Mediator {
    /**
     * Method to get the name.
     *
     * @param colleague colleague
     * @param request   request
     */
    void requestAll(Colleague colleague, String request);
}
