package patterns.structure.bridge.colors;

/**
 * Color.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/24/2019
 */
public class Color implements Palette {
    @Override
    public final void setColor(final String color) {
        System.out.println("Shape color: " + color);
    }
}
