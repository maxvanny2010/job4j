package patterns.behavior.state.stateaction;

/**
 * ActionStart.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/14/2019
 */
@SuppressWarnings("unused")
public class ActionStart implements State {
    @Override
    public final void doAction(final Context context) {
        System.out.println("Action start in");
        context.setContext(this);
    }

    @Override
    public final String toString() {
        return "ActionStart";
    }
}
