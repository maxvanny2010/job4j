package patterns.behavior.state.statewater;

/**
 * Water.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/23/2019
 */
public class Water {
    /**
     * field state.
     */
    private WaterState state;

    /**
     * Getter the state.
     *
     * @return the state
     */
    @SuppressWarnings("unused")
    public final WaterState getState() {
        return this.state;
    }

    /**
     * Setter the state.
     *
     * @param aState the state
     */
    public final void setState(final WaterState aState) {
        this.state = aState;
    }
}
