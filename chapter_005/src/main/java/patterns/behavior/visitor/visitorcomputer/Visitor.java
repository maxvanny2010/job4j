package patterns.behavior.visitor.visitorcomputer;

/**
 * ComputerPartDisplayVisitor.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/30/2019
 */
public class Visitor implements IVisitor {

    @Override
    public final void visit(final Computer computer) {
        System.out.println("Displaying Computer.");
    }

    @Override
    public final void visit(final Mouse mouse) {
        System.out.println("Displaying Mouse.");
    }

    @Override
    public final void visit(final Keyboard keyboard) {
        System.out.println("Displaying Keyboard.");
    }

    @Override
    public final void visit(final Monitor monitor) {
        System.out.println("Displaying Monitor.");
    }
}
