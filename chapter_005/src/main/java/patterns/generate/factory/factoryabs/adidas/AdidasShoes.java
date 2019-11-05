package patterns.generate.factory.factoryabs.adidas;

/**
 * AdidasShoes.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/25/2019
 */
@SuppressWarnings("unused")
public class AdidasShoes implements AdidasProduct {
    @Override
    public final String makeAdidasProduct() {
        return "adidas shoes";
    }

    @Override
    public final boolean isNull() {
        return false;
    }

    @Override
    public final String toString() {
        return AdidasShoes.class.getSimpleName();
    }
}
