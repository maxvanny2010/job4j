package patterns.generate.builder.cfc.drink;

/**
 * Pepsi.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/27/2019
 */
public class Pepsi extends ColdDrink {
    /**
     * field float.
     */
    private static final float FLOAT = 35.0f;

    @Override
    public final float price() {
        return FLOAT;
    }

    @Override
    public final String name() {
        return "Pepsi";
    }
}
