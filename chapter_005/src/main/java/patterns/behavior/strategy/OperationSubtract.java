package patterns.behavior.strategy;

/**
 * OperationSubtract.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/30/2019
 */
public class OperationSubtract implements Strategy {
    @Override
    public final int doOperation(final int num1, final int num2) {
        return num1 - num2;
    }
}
