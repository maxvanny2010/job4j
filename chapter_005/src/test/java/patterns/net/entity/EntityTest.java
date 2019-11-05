package patterns.net.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * EntityCompositeTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/31/2019
 */
public class EntityTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private Client client = new Client();

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
    }


    @Test
    public void whenServiceEJB() {
        this.client.setData("one", "two");
        this.client.printData();
        this.client.setData("three", "four");
        this.client.printData();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Data: one")
                .append(System.lineSeparator())
                .append("Data: two")
                .append(System.lineSeparator())
                .append("Data: three")
                .append(System.lineSeparator())
                .append("Data: four")
                .append(System.lineSeparator())
                .toString())
        );
    }

}
