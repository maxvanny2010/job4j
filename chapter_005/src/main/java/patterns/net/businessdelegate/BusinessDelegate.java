package patterns.net.businessdelegate;

/**
 * BusinessDelegate.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/31/2019
 */
class BusinessDelegate {
    /**
     * field factory.
     */
    private final BusinessFactory factory = new BusinessFactory();
    /**
     * field type.
     */
    private String serviceType;

    /**
     * Setter.
     *
     * @param type type
     */
    final void setServiceType(final String type) {
        this.serviceType = type;
    }

    /**
     * Method to task.
     */
    final void doTask() {
        final var service = this.factory.getService(this.serviceType);
        service.doProcessing();
    }
}
