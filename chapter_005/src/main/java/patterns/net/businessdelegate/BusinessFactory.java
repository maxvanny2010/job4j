package patterns.net.businessdelegate;

/**
 * BusinessFactory.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/31/2019
 */
class BusinessFactory {
    /**
     * Method get service.
     *
     * @param serviceType type
     * @return the service
     */
    final BusinessService getService(final String serviceType) {
        if (serviceType.equalsIgnoreCase("EJB")) {
            return new EJBService();
        } else {
            return new JMSService();
        }
    }
}
