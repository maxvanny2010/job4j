package patterns.behavior.template;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TemplateJobTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/30/2019
 */
public class TemplateTest {
    private final Template base = new TemplateBase();
    private final Template another = new TemplateAnother();
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
        this.base.run();
        this.another.run();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("step One base")
                .append(System.lineSeparator())
                .append("step Two base")
                .append(System.lineSeparator())
                .append("step Three base")
                .append(System.lineSeparator())
                .append("step One another")
                .append(System.lineSeparator())
                .append("step Two another")
                .append(System.lineSeparator())
                .append("step Three another")
                .append(System.lineSeparator())
                .toString()));
    }
}
