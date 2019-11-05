package patterns.generate.factory.factoryabs.nike;

/**
 * NikeNull.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/25/2019
 */
public class NikeNull implements NikeProduct {
    @Override
    public final String makeNikeProduct() {
        return null;
    }

    @SuppressWarnings("unused")
    @Override
    public final boolean isNull() {
        return true;
    }

    @Override
    public final String toString() {
        return NikeNull.class.getSimpleName();
    }
}
