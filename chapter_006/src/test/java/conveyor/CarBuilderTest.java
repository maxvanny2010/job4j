package conveyor;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * CarBuilderTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/11/2020
 */
public class CarBuilderTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void setAfter() {
        new PrintStream(System.out);
    }

    @Test
    public void testMain() {
        CarBuilder.main(new String[]{"args"});
        Assert.assertTrue(this.bos.size() > 0);
    }
}
