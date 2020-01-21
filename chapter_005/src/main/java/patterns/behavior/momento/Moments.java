package patterns.behavior.momento;

/**
 * Moments.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/29/2019
 */
public class Moments {
    /**
     * field state.
     */
    private final String state;

    /**
     * Constructor.
     *
     * @param aState state
     */
    Moments(final String aState) {
        this.state = aState;
    }

    /**
     * Setter.
     *
     * @return state
     */
    public final String getState() {
        return this.state;
    }
}
