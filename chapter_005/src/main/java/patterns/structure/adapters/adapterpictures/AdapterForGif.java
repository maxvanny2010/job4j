package patterns.structure.adapters.adapterpictures;

/**
 * Adapter2DToGif.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/24/2019
 */
public class AdapterForGif implements Viewers {
    /**
     * field the gif.
     */
    private ViewerGif gif;

    /**
     * Constructor.
     *
     * @param format the format
     */
    @SuppressWarnings("unused")
    AdapterForGif(final String format) {
        if (format.equalsIgnoreCase(".gif")) {
            this.gif = new ViewerGif();
        }
    }

    @Override
    public final void printFileFormat(final String format, final String name) {
        if (format.equalsIgnoreCase(".gif")) {
            this.gif.printGif(name);
        }
    }
}
