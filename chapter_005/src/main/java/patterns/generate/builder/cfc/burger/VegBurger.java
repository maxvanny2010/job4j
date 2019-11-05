package patterns.generate.builder.cfc.burger;

/**
 * VegBurger.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/27/2019
 */
public class VegBurger extends Burger {
    /**
     * field float.
     */
    private static final float FLOAT = 25.0f;

    @Override
    public final float price() {
        return FLOAT;
    }

    @Override
    public final String name() {
        return "Veg Burger";
    }
}
