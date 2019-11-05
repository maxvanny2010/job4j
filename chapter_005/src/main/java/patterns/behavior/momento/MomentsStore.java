package patterns.behavior.momento;

/**
 * MomentsCare.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/29/2019
 */
class MomentsStore {
    /**
     * field moment.
     */
    private Moments moment;

    /**
     * Method to get moment.
     *
     * @return moment
     */
    final Moments getMoment() {
        return this.moment;
    }

    /**
     * Method to set moment.
     *
     * @param sMoments moment
     */
    final void setMoment(final Moments sMoments) {
        this.moment = sMoments;
    }
}
