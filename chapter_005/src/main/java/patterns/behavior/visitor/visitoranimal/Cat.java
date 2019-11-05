package patterns.behavior.visitor.visitoranimal;

/**
 * Cat.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/30/2019
 */
public class Cat implements IAnimal {
    @Override
    public final void doJob(final IVisitor visitor) {
        visitor.doCat();
    }
}
