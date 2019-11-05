package patterns.structure.decorator.decoratorprice;

/**
 * Decorator.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/24/2019
 */
abstract class Decorator implements Product {
    /**
     * field a product.
     */
    private final Product product;

    /**
     * Constructor.
     *
     * @param aProduct the product
     */
    Decorator(final Product aProduct) {
        this.product = aProduct;
    }

    /**
     * Getter the product.
     *
     * @return the product
     */
    final Product getProduct() {
        return this.product;
    }
}
