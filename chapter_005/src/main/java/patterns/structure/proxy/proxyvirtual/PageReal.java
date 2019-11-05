package patterns.structure.proxy.proxyvirtual;

/**
 * PageReal.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/23/2019
 */
@SuppressWarnings("unused")
public class PageReal implements Page {
    /**
     * field page.
     */
    private final String page;

    /**
     * Constructor.
     *
     * @param aPage page
     */
    PageReal(final String aPage) {
        this.page = aPage;
        this.load();
    }

    /**
     * Method to load a page.
     */
    private void load() {
        System.out.println("Loading page " + this.page + "...");
    }

    @Override
    public final void display() {
        System.out.println("Display page " + this.page + "...");
    }
}
