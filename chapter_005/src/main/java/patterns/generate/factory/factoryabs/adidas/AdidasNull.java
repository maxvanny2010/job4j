package patterns.generate.factory.factoryabs.adidas;

/**
 * .
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/25/2019
 */
public class AdidasNull implements AdidasProduct {
    @Override
    public final String makeAdidasProduct() {
        return null;
    }

    @SuppressWarnings("unused")
    @Override
    public final boolean isNull() {
        return true;
    }

    @Override
    public final String toString() {
        return AdidasNull.class.getSimpleName();
    }
}
