package delay;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * DelayDemoTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/14/2020
 */
public class DelayDemoTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    @Before
    public void setBosBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void setOutAfter() {
        new PrintStream(System.out);
    }

    @Test
    public void whenTestMainOK() {
        DelayDemo.main(new String[]{"args"});
    }
}
