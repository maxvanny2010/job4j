package patterns.behavior.visitor.visitorcomputer;

/**
 * Computer.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/30/2019
 */
public class Computer implements IComputerPart {
    /**
     * field parts.
     */
    private final IComputerPart[] parts;

    /**
     * Constructor.
     */
    Computer() {
        this.parts = new IComputerPart[]
                {new Mouse(), new Keyboard(), new Monitor()};
    }

    @Override
    public final void accept(final IVisitor visitor) {
        visitor.visit(this);
        for (final IComputerPart part : this.parts) {
            part.accept(visitor);
        }
    }
}
