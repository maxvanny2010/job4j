package ua.autos.model.ads;

import java.util.StringJoiner;

/**
 * Status.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
public enum Status {
    /**
     * field a yes.
     */
    YES("yes"),
    /**
     * field a no.
     */
    NO("no");
    /**
     * field a status.
     */
    private String status;

    /**
     * Constructor.
     *
     * @param aStatus a status
     */
    Status(final String aStatus) {
        this.status = aStatus;
    }

    /**
     * Method to get.
     *
     * @return a status
     */
    public final String getStatus() {
        return this.status;
    }

    /**
     * Method to set.
     *
     * @param aStatus a status
     **/
    public final void setStatus(final String aStatus) {
        this.status = aStatus;
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Status.class.getSimpleName() + "[", "]")
                .add("status='" + this.status + "'")
                .toString();
    }
}
