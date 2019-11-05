package patterns.behavior.iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * RepoTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/13/2019
 */
public class RepoInnerTest {
    private final RepoInner repo = new RepoInner();
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
    public void whenIteratorOk() {
        final Iterator iter = this.repo.getIterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        assertThat(bos.toString(), is(new StringBuilder()
                .append("A ")
                .append("B ")
                .append("C ")
                .append("D ")
                .toString()));
    }

}
