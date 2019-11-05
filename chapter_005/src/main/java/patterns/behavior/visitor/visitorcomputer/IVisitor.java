package patterns.behavior.visitor.visitorcomputer;

/**
 * ComputerPartVisitor.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/30/2019
 */
interface IVisitor {
    /**
     * Method to visit.
     *
     * @param computer computer
     */
    @SuppressWarnings("unused")
    void visit(Computer computer);

    /**
     * Method to visit.
     *
     * @param mouse mouse
     */
    @SuppressWarnings("unused")
    void visit(Mouse mouse);

    /**
     * Method to visit.
     *
     * @param keyboard keyboard
     */
    @SuppressWarnings("unused")
    void visit(Keyboard keyboard);

    /**
     * Method to visit.
     *
     * @param monitor monitor
     */
    @SuppressWarnings("unused")
    void visit(Monitor monitor);
}
