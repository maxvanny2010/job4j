package patterns.behavior.state.stateaction;

/**
 * ActionStop.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/14/2019
 */
public class ActionStop implements State {
    @Override
    public final void doAction(final Context context) {
        System.out.println("Action stop in");
        context.setContext(this);
    }

    @Override
    public final String toString() {
        return "ActionStop";
    }
}
