package patterns.generate.factory.factoryabs.nike;

/**
 * NikeShoes.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/25/2019
 */
public class NikeShoes implements NikeProduct {
    @SuppressWarnings("unused")
    @Override
    public final String makeNikeProduct() {
        return "nike shoes";
    }

    @SuppressWarnings("unused")
    @Override
    public final boolean isNull() {
        return false;
    }

    @Override
    public final String toString() {
        return NikeShoes.class.getSimpleName();
    }
}
