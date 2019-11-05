package patterns.behavior.visitor.visitorcomputer;

/**
 * ComputePart.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/30/2019
 */
public interface IComputerPart {
    /**
     * Method accept.
     *
     * @param visitor visitor
     */
    void accept(IVisitor visitor);
}
