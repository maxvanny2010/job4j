package patterns.net.businessdelegate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ClientTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/31/2019
 */
public class DelegateTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final BusinessDelegate delegate = new BusinessDelegate();
    private Client client;

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
        this.delegate.setServiceType("EJB");
        this.client = new Client(this.delegate);
        this.client.doTask();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Processing task by invoking EJB Service")
                .append(System.lineSeparator())
                .toString())
        );
    }

    @Test
    public void whenServiceJMS() {
        this.delegate.setServiceType("JMS");
        this.client = new Client(this.delegate);
        this.client.doTask();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Processing task by invoking JMS Service")
                .append(System.lineSeparator())
                .toString())
        );
    }

}
