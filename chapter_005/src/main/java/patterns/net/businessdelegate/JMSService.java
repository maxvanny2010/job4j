package patterns.net.businessdelegate;

/**
 * JMSService.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/31/2019
 */
public class JMSService implements BusinessService {
    @Override
    public final void doProcessing() {
        System.out.println("Processing task by invoking JMS Service");
    }
}
