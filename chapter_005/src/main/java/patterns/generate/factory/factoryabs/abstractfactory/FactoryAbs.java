package patterns.generate.factory.factoryabs.abstractfactory;

import patterns.generate.factory.factoryabs.adidas.AdidasProduct;
import patterns.generate.factory.factoryabs.nike.NikeProduct;

/**
 * FactoryAbs.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/25/2019
 */
@SuppressWarnings("unused")
public abstract class FactoryAbs {
    /**
     * Method to get product.
     *
     * @param product the product
     * @return the product
     */
    public abstract AdidasProduct getAdidasProduct(String product);

    /**
     * Method to get product.
     *
     * @param product the product
     * @return the product
     */

    public abstract NikeProduct getNikeProduct(String product);

    /**
     * Method is Null.
     *
     * @return result
     */
    public abstract boolean isNull();
}
