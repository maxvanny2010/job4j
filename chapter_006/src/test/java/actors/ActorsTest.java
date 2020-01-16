package actors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

/**
 * ActorsTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/16/2020
 */
public class ActorsTest {
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
    public void testMain() {
        Actors.main(new String[]{"args"});
        assertTrue(this.bos.size() > 0);
    }
}
