package patterns.behavior.visitor.visitorcomputer;

/**
 * Mouse.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/30/2019
 */
public class Mouse implements IComputerPart {
    @Override
    public final void accept(final IVisitor visitor) {
        visitor.visit(this);
    }
}
