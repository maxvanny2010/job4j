package patterns.structure.proxy.proxyvirtual;

/**
 * PageProxy.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/23/2019
 */
public class PageProxy implements Page {
    /**
     * field page.
     */
    private final String page;
    /**
     * field real.
     */
    private PageReal real;

    /**
     * Constructor.
     *
     * @param aPage page
     */
    PageProxy(final String aPage) {
        this.page = aPage;
    }

    @SuppressWarnings("unused")
    @Override
    public final void display() {
        if (this.real == null) {
            this.real = new PageReal(this.page);
        }
        this.real.display();
    }
}
