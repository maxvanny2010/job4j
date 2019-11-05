package patterns.structure.adapters.adapterdb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ApplicationAdapterTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/24/2019
 */
public class ApplicationAdapterTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final DataBase db = new AdapterDB();

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
    }


    @Test
    public void whenAdapterInsert() {
        this.db.insert();
        assertThat(this.bos.toString(), is("insert"));
    }

    @Test
    public void whenAdapterUpdate() {
        this.db.update();
        assertThat(this.bos.toString(), is("update"));
    }

    @Test
    public void whenAdapterRemove() {
        this.db.remove();
        assertThat(this.bos.toString(), is("remove"));
    }
}
