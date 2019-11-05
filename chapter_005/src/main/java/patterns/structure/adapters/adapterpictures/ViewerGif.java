package patterns.structure.adapters.adapterpictures;

/**
 * ViewerGif.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/24/2019
 */
@SuppressWarnings("unused")
public class ViewerGif implements ViewersGif {
    @Override
    public final void printGif(final String name) {
        System.out.printf("Print %s.gif", name);
    }
}
