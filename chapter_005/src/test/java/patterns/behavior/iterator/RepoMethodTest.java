package patterns.behavior.iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * RepoMethodTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/13/2019
 */
public class RepoMethodTest {
    private final List<Integer> list = List.of(1, 2, 3, 4);
    private final RepoMethod<Integer> method = new RepoMethod<>(this.list);
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
        final Iterator iterator = this.method.getIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        assertThat(bos.toString(), is(new StringBuilder()
                .append("1 ")
                .append("2 ")
                .append("3 ")
                .append("4 ")
                .toString()));
    }

}
