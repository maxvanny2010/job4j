package patterns.structure.proxy.proxystatic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static patterns.structure.proxy.proxystatic.SimpleProxy.consumer;

/**
 * SimpleProxyMainTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/23/2019
 */
public class ProxyStaticTest {
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
    public void whenConsumerHaveProxy() {
        final var ls = System.lineSeparator();
        consumer(new ObjectProxy(new ObjectReal()));
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Proxy doSomething")
                .append(ls)
                .append("Real doSomeThing")
                .append(ls)
                .append("Proxy doSomething iFace")
                .append(ls)
                .append("Real someThingElse iFace")
                .append(ls)
                .toString()
        ));
    }

    @Test
    public void whenConsumerDontHave() {
        final var ls = System.lineSeparator();
        consumer(new ObjectReal());
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Real doSomeThing")
                .append(ls)
                .append("Real someThingElse iFace")
                .append(ls)
                .toString()
        ));
    }
}
