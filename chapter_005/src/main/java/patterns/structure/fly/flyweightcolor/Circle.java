package patterns.structure.fly.flyweightcolor;

/**
 * Circle.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/14/2019
 */
public class Circle {
    /**
     * field color.
     */
    private final String color;

    /**
     * Constructor.
     *
     * @param aColor color
     */
    Circle(final String aColor) {
        this.color = aColor;
    }

    /**
     * Getter.
     *
     * @return the color
     */
    @SuppressWarnings("unused")
    public final String getColor() {
        return this.color;
    }

    /**
     * Setter.
     *
     * @param aX x
     */
    @SuppressWarnings({"unused", "EmptyMethod"})
    public final void setX(final int aX) {
    }

    /**
     * Setter.
     *
     * @param aY y
     */
    @SuppressWarnings({"unused", "EmptyMethod"})
    public final void setY(final int aY) {
    }

}
