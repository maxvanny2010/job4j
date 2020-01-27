package loggger;

import org.junit.Test;

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
    @Test
    public void testGetLoggerLevel() {
        LogAnyClass.setLoggerLevel(Level.INFO);
        final Level result = LogAnyClass.getLoggerLevel();
        assertThat(result.toString(), is(Level.INFO.getName()));
    }
}
