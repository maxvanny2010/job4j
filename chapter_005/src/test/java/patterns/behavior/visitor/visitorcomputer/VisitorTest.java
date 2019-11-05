package patterns.behavior.visitor.visitorcomputer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ComputerTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/30/2019
 */
public class VisitorTest {
    private final IComputerPart computer = new Computer();
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
    public void whenTemplateBaseAndAnotherRun() {
        this.computer.accept(new Visitor());
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Displaying Computer.")
                .append(System.lineSeparator())
                .append("Displaying Mouse.")
                .append(System.lineSeparator())
                .append("Displaying Keyboard.")
                .append(System.lineSeparator())
                .append("Displaying Monitor.")
                .append(System.lineSeparator())
                .toString()));
    }
}
