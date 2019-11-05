package patterns.behavior.mediator;

/**
 * Colleague.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/29/2019
 */
interface Colleague {
    /**
     * Method to get the name.
     *
     * @return name
     */
    String getName();

    /**
     * Method status.
     *
     * @return status
     */
    boolean isStatus();

    /**
     * Method to set boolean.
     */
    void setFalse();

    /**
     * Method to set boolean.
     */
    void setTrue();

    /**
     * Method to set letter.
     */
    void setLetterNull();

    /**
     * Method to sent the request.
     *
     * @param request the request
     */
    void sentRequest(String request);

    /**
     * Method to get the letter.
     *
     * @return letter
     */
    String getLetter();

    /**
     * Method to set the letter.
     *
     * @param letter letter
     */
    void setLetter(String letter);
}
