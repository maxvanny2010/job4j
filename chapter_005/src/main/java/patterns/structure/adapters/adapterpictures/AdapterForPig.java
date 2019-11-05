package patterns.structure.adapters.adapterpictures;

/**
 * AdapterForPig.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/24/2019
 */
public class AdapterForPig extends ViewerPig implements Viewers {
    @Override
    public final void printFileFormat(final String format, final String name) {
        super.printPig(name);
    }
}
