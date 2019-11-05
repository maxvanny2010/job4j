package patterns.structure.decorator.decoratorprice;

/**
 * Decorator15.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/24/2019
 */
public class Decorator15 extends Decorator {
    /**
     * field discount.
     */
    private final int discount;

    /**
     * Constructor.
     *
     * @param product   the product
     * @param aDiscount the discount
     */
    Decorator15(final Product product, final int aDiscount) {
        super(product);
        this.discount = aDiscount;
    }

    /**
     * Method to get discount.
     *
     * @return the discount
     */
    private int getDiscount() {
        return this.discount;
    }

    @Override
    public final int getPrice() {
        return this.getProduct().getPrice() - this.getDiscount();
    }
}
