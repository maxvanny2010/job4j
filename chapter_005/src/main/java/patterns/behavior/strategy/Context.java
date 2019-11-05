package patterns.behavior.strategy;

/**
 * Context.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/30/2019
 */
public class Context {
    /**
     * field strategy.
     */
    private final Strategy strategy;

    /**
     * Constructor.
     *
     * @param aStrategy strategy
     */
    Context(final Strategy aStrategy) {
        this.strategy = aStrategy;
    }

    /**
     * Method execute.
     *
     * @param num1 num1
     * @param num2 num2
     * @return result of execute
     */
    final int executeStrategy(final int num1, final int num2) {
        return this.strategy.doOperation(num1, num2);
    }
}
