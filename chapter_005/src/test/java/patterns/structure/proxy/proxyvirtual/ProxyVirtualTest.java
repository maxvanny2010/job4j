package patterns.structure.proxy.proxyvirtual;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ProxyVirtualTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/23/2019
 */
public class ProxyVirtualTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final Page google = new PageProxy("google");
    private final Page fb = new PageProxy("fb");

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
    }


    @Test
    public void whenGoogleHaveProxy() {
        final var ls = System.lineSeparator();
        this.google.display();
        this.google.display();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Loading page google...")
                .append(ls)
                .append("Display page google...")
                .append(ls)
                .append("Display page google...")
                .append(ls)
                .toString()
        ));
    }

    @Test
    public void whenFbHaveProxy() {
        final var ls = System.lineSeparator();
        this.fb.display();
        this.fb.display();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Loading page fb...")
                .append(ls)
                .append("Display page fb...")
                .append(ls)
                .append("Display page fb...")
                .append(ls)
                .toString()
        ));
    }
}
