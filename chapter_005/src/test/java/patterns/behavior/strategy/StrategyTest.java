package patterns.behavior.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * StrategyTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/30/2019
 */
public class StrategyTest {
    private final Strategy add = new OperationAdd();
    private final Strategy minus = new OperationSubtract();
    private final Strategy multi = new OperationMultiply();
    private Context context;

    @Test
    public void whenStrategyAdd() {
        this.context = new Context(this.add);
        final int result = this.context.executeStrategy(1, 2);
        assertThat(result, is(3));
    }

    @Test
    public void whenStrategyMinus() {
        this.context = new Context(this.minus);
        final int result = this.context.executeStrategy(2, 1);
        assertThat(result, is(1));
    }

    @Test
    public void whenStrategyMultiply() {
        this.context = new Context(this.multi);
        final int result = this.context.executeStrategy(2, 1);
        assertThat(result, is(2));
    }

}
