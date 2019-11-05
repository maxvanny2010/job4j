package patterns.behavior.visitor.visitoranimal;

/**
 * VisitorConcrete.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/30/2019
 */
public class VisitorConcrete implements IVisitor {
    @Override
    public final void doDog() {
        System.out.println("gav");
    }

    @Override
    public final void doCat() {
        System.out.println("may");
    }
}
