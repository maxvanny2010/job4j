package patterns.behavior.state.stateupper;

/**
 * State.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/14/2019
 */
interface State {
    /**
     * Method to do the action.
     *
     * @param context context
     */
    void doAction(Context context);
}
