package patterns.behavior.chain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static patterns.behavior.chain.LoggerMain.baseChain;

/**
 * .
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/13/2019
 */
public class LoggerMainTest {
    private final LoggerAbstract logger = baseChain();
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    @Before
    public void setOutBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void setOutAfter() {
        System.setOut(System.out);
    }

    @Test
    public void whenChainOk() {
        this.logger.logMessage(LoggerAbstract.INFO, "INFO");
        this.logger.logMessage(LoggerAbstract.DEBUG, "DEBUG");
        this.logger.logMessage(LoggerAbstract.ERROR, "ERROR");
        final String ls = System.lineSeparator();
        assertThat(bos.toString(), is(new StringBuilder()
                .append("standard::INFO::INFO")
                .append(ls)
                .append("standard::DEBUG::DEBUG")
                .append(ls)
                .append("standard::INFO::DEBUG")
                .append(ls)
                .append("standard::ERROR::ERROR")
                .append(ls)
                .append("standard::DEBUG::ERROR")
                .append(ls)
                .append("standard::INFO::ERROR")
                .append(ls)
                .toString()));
    }
}
