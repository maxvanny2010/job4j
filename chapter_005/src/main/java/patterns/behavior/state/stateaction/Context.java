package patterns.behavior.state.stateaction;

/**
 * Context.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/14/2019
 */
class Context {
    /**
     * field state.
     */
    private State state;

    /**
     * Constructor.
     */
    Context() {
        this.state = null;
    }

    /**
     * Getter.
     *
     * @return context
     */
    State getContext() {
        return this.state;
    }

    /**
     * Setter.
     *
     * @param aState state
     */
    void setContext(final State aState) {
        this.state = aState;
    }
}
