package patterns.structure.decorator.decoratorprice;

/**
 * Milk.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/24/2019
 */
public class Milk implements Product {
    /**
     * field a price.
     */

    private final int price;

    /**
     * Constructor.
     *
     * @param aPrice the price
     */
    @SuppressWarnings("SameParameterValue")
    Milk(final int aPrice) {
        this.price = aPrice;
    }

    @SuppressWarnings("unused")
    @Override
    public final int getPrice() {
        return this.price;
    }
}
