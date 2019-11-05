package patterns.generate.factory.factoryabs.nike;

/**
 * NikeProduct.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/25/2019
 */
@SuppressWarnings("unused")
public interface NikeProduct {
    /**
     * Method to make product.
     *
     * @return the product
     */
    String makeNikeProduct();

    /**
     * Method is Null.
     *
     * @return result
     */
    boolean isNull();
}

