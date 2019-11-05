package patterns.generate.builder.cfc.burger;

/**
 * ChickenBurger.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/27/2019
 */
public class ChickenBurger extends Burger {
    /**
     * field float.
     */
    private static final float FLOAT = 50.5f;

    @Override
    public final float price() {
        return FLOAT;
    }

    @Override
    public final String name() {
        return "Chicken Burger";
    }
}
