package cashbox;

/**
 * Customer.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/16/2020
 */
class Customer {
    /**
     * field a time for service.
     */
    private final int serviceTime;

    /**
     * Constructor.
     *
     * @param aServiceTime a service time
     */
    Customer(final int aServiceTime) {
        this.serviceTime = aServiceTime;
    }

    /**
     * Method to get.
     *
     * @return serviceTime
     */
    final int getServiceTime() {
        return this.serviceTime;
    }

    @Override
    public final String toString() {
        return String.format("[ %s ]", this.serviceTime);
    }
}
