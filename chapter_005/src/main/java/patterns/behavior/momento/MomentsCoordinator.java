package patterns.behavior.momento;

/**
 * MomentsOriginator.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/29/2019
 */
public class MomentsCoordinator {
    /**
     * field state.
     */
    private String state;

    /**
     * Method to get.
     *
     * @return state
     */
    public final String getState() {
        return this.state;
    }

    /**
     * Method to set.
     *
     * @param aState state
     */
    public final void setState(final String aState) {
        this.state = aState;
    }

    /**
     * Method to create.
     *
     * @return moments
     */
    final Moments createMoment() {
        return new Moments(this.state);
    }

    /**
     * Method to get state moments.
     *
     * @param moments moments
     */
    final void getStateFromMoment(final Moments moments) {
        this.state = moments.getState();
    }
}
