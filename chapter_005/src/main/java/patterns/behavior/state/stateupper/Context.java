package patterns.behavior.state.stateupper;

/**
 * Context.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/14/2019
 */
public class Context {
    /**
     * field name.
     */
    private final String name;
    /**
     * field state.
     */
    private State state;

    /**
     * Constructor.
     *
     * @param aState state
     * @param aName  name
     */
    public Context(final State aState, final String aName) {
        this.state = aState;
        this.name = aName;
    }

    /**
     * Setter.
     *
     * @param aState state
     */
    final void setState(final State aState) {
        this.state = aState;
    }

    /**
     * Method to do the concrete action.
     */
    final void doAction() {
        this.state.doAction(this);
    }

    /**
     * Getter.
     *
     * @return name
     */
    public final String getName() {
        return this.name;
    }
}
