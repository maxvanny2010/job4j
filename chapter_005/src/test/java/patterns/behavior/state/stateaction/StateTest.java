package patterns.behavior.state.stateaction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * StateTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/14/2019
 */
public class StateTest {
    private final State stop = new ActionStop();
    private final State start = new ActionStart();
    private final Context context = new Context();
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
    }

    @Test
    public void whenActionStartOk() {
        this.start.doAction(this.context);
        System.out.print(this.context.getContext());
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Action start in")
                .append(System.lineSeparator())
                .append("ActionStart")
                .toString()));
    }

    @Test
    public void whenActionStopOk() {
        this.stop.doAction(this.context);
        System.out.print(this.context.getContext());
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Action stop in")
                .append(System.lineSeparator())
                .append("ActionStop")
                .toString()));
    }
}
