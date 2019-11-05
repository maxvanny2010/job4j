package patterns.generate.factory.factoryabs.nike;

import patterns.generate.factory.factoryabs.abstractfactory.FactoryAbs;
import patterns.generate.factory.factoryabs.adidas.AdidasProduct;

import java.util.Map;

/**
 * NikeFactory.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/25/2019
 */
public class NikeFactory extends FactoryAbs {
    /**
     * field map.
     */
    private final Map<String, NikeProduct> nike = Map.of(
            "nike outwear", new NikeOutWear(),
            "nike shoes", new NikeShoes());

    @Override
    public final NikeProduct getNikeProduct(final String product) {
        return this.nike.getOrDefault(product.toLowerCase(), new NikeNull());
    }

    @SuppressWarnings("unused")
    @Override
    public final boolean isNull() {
        return false;
    }

    @Override
    public final AdidasProduct getAdidasProduct(final String product) {
        return null;
    }

    @Override
    public final String toString() {
        return NikeFactory.class.getSimpleName();
    }
}
