package patterns.structure.bridge.shape;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import patterns.structure.bridge.colors.Color;
import patterns.structure.bridge.colors.Palette;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * .
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/24/2019
 */
public class SquareBridgeTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final Palette color = new Color();
    private final Drawer square = new Square(this.color);


    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
    }


    @Test
    public void whenBridgeGreen() {
        this.square.drawShape("#00FF00");
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Shape color: Green")
                .append(System.lineSeparator())
                .toString()));
    }

    @Test
    public void whenBridgeRed() {
        this.square.drawShape("#FF0000");
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Shape color: Red")
                .append(System.lineSeparator())
                .toString()));
    }

    @Test
    public void whenBridgeBlue() {
        this.square.drawShape("#0000FF");
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Shape color: Blue")
                .append(System.lineSeparator())
                .toString()));
    }

    @Test
    public void whenBridgeUndefined() {
        this.square.drawShape("#00000F");
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Undefined color")
                .append(System.lineSeparator())
                .toString()));
    }
}
