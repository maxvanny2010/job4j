package patterns.generate.factory.factoryabs.adidas;

/**
 * AdidasOutWear.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/25/2019
 */
public class AdidasOutWear implements AdidasProduct {
    @Override
    public final String makeAdidasProduct() {
        return "adidas outwear";
    }

    @SuppressWarnings("unused")
    @Override
    public final boolean isNull() {
        return false;
    }

    @Override
    public final String toString() {
        return AdidasOutWear.class.getSimpleName();
    }
}
