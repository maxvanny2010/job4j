package patterns.generate.factory.factoryabs.adidas;

/**
 * AdidasProduct.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/25/2019
 */
public interface AdidasProduct {
    /**
     * Method to make product.
     *
     * @return the product
     */
    String makeAdidasProduct();

    /**
     * Method is Null.
     *
     * @return result
     */
    @SuppressWarnings("unused")
    boolean isNull();
}
