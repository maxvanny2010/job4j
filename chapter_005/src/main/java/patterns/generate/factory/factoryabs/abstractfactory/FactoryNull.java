package patterns.generate.factory.factoryabs.abstractfactory;

import patterns.generate.factory.factoryabs.adidas.AdidasNull;
import patterns.generate.factory.factoryabs.adidas.AdidasProduct;
import patterns.generate.factory.factoryabs.nike.NikeNull;
import patterns.generate.factory.factoryabs.nike.NikeProduct;

/**
 * FactoryNull.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/26/2019
 */
@SuppressWarnings("unused")
public class FactoryNull extends FactoryAbs {
    @Override
    public final AdidasProduct getAdidasProduct(final String product) {
        return new AdidasNull();
    }

    @SuppressWarnings("unused")
    @Override
    public final NikeProduct getNikeProduct(final String product) {
        return new NikeNull();
    }

    @Override
    public final boolean isNull() {
        return true;
    }

    @Override
    public final String toString() {
        return FactoryNull.class.getSimpleName();
    }
}
