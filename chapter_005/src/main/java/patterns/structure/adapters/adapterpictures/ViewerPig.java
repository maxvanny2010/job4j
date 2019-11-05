package patterns.structure.adapters.adapterpictures;

/**
 * .
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/25/2019
 */
public class ViewerPig implements ViewersPig {
    @Override
    public final void printPig(final String name) {
        System.out.printf("Print %s.pig", name);
    }
}
