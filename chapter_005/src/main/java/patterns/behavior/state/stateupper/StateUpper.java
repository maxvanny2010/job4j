package patterns.behavior.state.stateupper;

/**
 * StateUpper.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/14/2019
 */
public class StateUpper implements State {
    @Override
    public final void doAction(final Context context) {
        System.out.println(context.getName().toUpperCase());
    }
}
