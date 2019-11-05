package patterns.net.businessdelegate;

/**
 * EJBService.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/31/2019
 */
public class EJBService implements BusinessService {
    @Override
    public final void doProcessing() {
        System.out.println("Processing task by invoking EJB Service");
    }
}
