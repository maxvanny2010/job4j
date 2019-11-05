package patterns.structure.adapters.adapterpictures;

/**
 * Viewer2D.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/24/2019
 */
public class Viewer implements Viewers {
    @SuppressWarnings("unused")
    @Override
    public final void printFileFormat(final String format, final String name) {
        switch (format) {
            case ".jpg":
            case ".png":
                System.out.printf("Print %s%s", name, format);
                break;
            case ".gif":
                new AdapterForGif(format).printFileFormat(format, name);
                break;
            case ".pig":
                new AdapterForPig().printFileFormat(format, name);
                break;
            default:
                System.out.printf("Don't print %s%s", name, format);
                break;
        }
    }
}
