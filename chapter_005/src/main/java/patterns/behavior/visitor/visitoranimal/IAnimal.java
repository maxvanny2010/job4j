package patterns.behavior.visitor.visitoranimal;

/**
 * Animal.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/30/2019
 */
public interface IAnimal {
    /**
     * Method to job.
     *
     * @param visitor visitor.
     */
    void doJob(IVisitor visitor);
}
