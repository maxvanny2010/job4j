package patterns.generate.builder.cfc.drink;

/**
 * Coke.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/27/2019
 */
public class Coke extends ColdDrink {
    /**
     * field float.
     */
    private static final float FLOAT = 30.0f;

    @Override
    public final float price() {
        return FLOAT;
    }

    @Override
    public final String name() {
        return "Coke";
    }
}
