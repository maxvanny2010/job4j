package patterns.generate.factory.factoryabs.nike;

/**
 * NikeOutWear.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/25/2019
 */
public class NikeOutWear implements NikeProduct {
    @Override
    public final String makeNikeProduct() {
        return "nike outwear";
    }

    @SuppressWarnings("unused")
    @Override
    public final boolean isNull() {
        return false;
    }

    @Override
    public final String toString() {
        return NikeOutWear.class.getSimpleName();
    }
}
