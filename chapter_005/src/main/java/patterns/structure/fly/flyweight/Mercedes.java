package patterns.structure.fly.flyweight;

/**
 * Mercedes.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/14/2019
 */
class Mercedes {
    /**
     * field color.
     */
    private String color;

    /**
     * Getter.
     *
     * @return color
     */
    @SuppressWarnings("unused")
    public final String getColor() {
        return this.color;
    }

    /**
     * Setter.
     *
     * @param aColor color
     */
    final void setColor(final String aColor) {
        this.color = aColor;
    }
}
