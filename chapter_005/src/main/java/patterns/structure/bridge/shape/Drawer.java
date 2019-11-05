package patterns.structure.bridge.shape;

import patterns.structure.bridge.colors.Palette;

/**
 * Drawer.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/24/2019
 */
public abstract class Drawer {
    /**
     * field a palette.
     */
    private final Palette palette;

    /**
     * Constructor.
     *
     * @param aPalette the palette
     */
    Drawer(final Palette aPalette) {
        this.palette = aPalette;
    }

    /**
     * Method to get the palette.
     *
     * @return the palette
     */
    final Palette getPalette() {
        return this.palette;
    }

    /**
     * Method to draw a shape.
     *
     * @param color the color shape
     */
    public abstract void drawShape(String color);
}
