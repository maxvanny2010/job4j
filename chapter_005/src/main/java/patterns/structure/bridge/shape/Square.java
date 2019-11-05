package patterns.structure.bridge.shape;

import patterns.structure.bridge.colors.Palette;

/**
 * Square.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/24/2019
 */
public class Square extends Drawer {
    /**
     * Constructor.
     *
     * @param aPalette the palette
     */
    Square(final Palette aPalette) {
        super(aPalette);
    }

    @SuppressWarnings("unused")
    @Override
    public final void drawShape(final String color) {
        switch (color) {
            case "#FF0000":
                this.getPalette().setColor("Red");
                break;
            case "#00FF00":
                this.getPalette().setColor("Green");
                break;
            case "#0000FF":
                this.getPalette().setColor("Blue");
                break;
            default:
                System.out.println("Undefined color");
        }
    }
}
