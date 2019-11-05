package patterns.behavior.state.stateaction;

/**
 * State.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/14/2019
 */
public interface State {
    /**
     * Method to create the action.
     *
     * @param context context
     */
    void doAction(Context context);
}
