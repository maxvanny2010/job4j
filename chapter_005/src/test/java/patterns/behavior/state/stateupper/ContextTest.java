package patterns.behavior.state.stateupper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ContextTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/14/2019
 */
public class ContextTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private State state;
    private Context context;

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
    }

    @Test
    public void whenStateUpperOK() {
        this.state = new StateLower();
        this.context = new Context(this.state, "max");
        this.context.doAction();
        this.state = new StateUpper();
        this.context.setState(this.state);
        this.context.doAction();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("max")
                .append(System.lineSeparator())
                .append("MAX")
                .append(System.lineSeparator())
                .toString()));
    }

    @Test
    public void whenStateLowerOK() {
        this.state = new StateUpper();
        this.context = new Context(this.state, "max");
        this.context.doAction();
        this.state = new StateLower();
        this.context.setState(this.state);
        this.context.doAction();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("MAX")
                .append(System.lineSeparator())
                .append("max")
                .append(System.lineSeparator())
                .toString()));
    }
}
