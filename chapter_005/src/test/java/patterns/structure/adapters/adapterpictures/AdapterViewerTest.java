package patterns.structure.adapters.adapterpictures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Viewer2DTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/24/2019
 */
public class AdapterViewerTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final Viewer viewer2D = new Viewer();


    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
    }


    @Test
    public void whenViewerPrintJpg() {
        this.viewer2D.printFileFormat(".jpg", "A");
        assertThat(this.bos.toString(), is("Print A.jpg"));
    }

    @Test
    public void whenViewerPrintPng() {
        this.viewer2D.printFileFormat(".png", "A");
        assertThat(this.bos.toString(), is("Print A.png"));
    }

    @Test
    public void whenViewerPrintAdapterGif() {
        this.viewer2D.printFileFormat(".gif", "A");
        assertThat(this.bos.toString(), is("Print A.gif"));
    }

    @Test
    public void whenViewerPrintAdapterPig() {
        this.viewer2D.printFileFormat(".pig", "A");
        assertThat(this.bos.toString(), is("Print A.pig"));
    }

    @Test
    public void whenViewerPrintFallFormat() {
        this.viewer2D.printFileFormat(".xxx", "A");
        assertThat(this.bos.toString(), is("Don't print A.xxx"));
    }


}
