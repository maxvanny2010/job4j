package patterns.behavior.strategy;

/**
 * Strategy.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/30/2019
 */
public interface Strategy {
    /**
     * Method to do the operation.
     *
     * @param num1 num1
     * @param num2 num2
     * @return result
     */
    int doOperation(int num1, int num2);
}
