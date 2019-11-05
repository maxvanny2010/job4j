package patterns.generate.factory.factoryabs.adidas;

import patterns.generate.factory.factoryabs.abstractfactory.FactoryAbs;
import patterns.generate.factory.factoryabs.nike.NikeProduct;

import java.util.Map;

/**
 * AdidasFactory.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/25/2019
 */
@SuppressWarnings("unused")
public class AdidasFactory extends FactoryAbs {
    /**
     * field map.
     */
    private final Map<String, AdidasProduct> adidas = Map.of(
            "adidas outwear", new AdidasOutWear(),
            "adidas shoes", new AdidasShoes());

    @Override
    public final AdidasProduct getAdidasProduct(final String product) {
        return this.adidas.getOrDefault(product.toLowerCase(),
                new AdidasNull());
    }

    @Override
    public final NikeProduct getNikeProduct(final String product) {
        return null;
    }

    @Override
    public final boolean isNull() {
        return false;
    }

    @Override
    public final String toString() {
        return AdidasFactory.class.getSimpleName();
    }
}
