package loggger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * LogAnyClassTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/23/2020
 */
public class LogAnyClassTest {

    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    @Before
    public void setBefore() {
        System.setErr(new PrintStream(this.bos));
        LogAnyClass.setLoggerLevel(Level.INFO);
    }

    @After
    public void setAfter() {
        new PrintStream(System.out);
    }


    @Test
    public void testGetLoggerLevel() {
        final Level result = LogAnyClass.getLoggerLevel();
        assertThat(result.toString(), is(Level.INFO.getName()));
    }

    @Test
    public void testMain() {
        LogAnyClass.main(new String[]{"args"});
        Assert.assertTrue(this.bos.size() > 0);
    }
}
