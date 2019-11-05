package patterns.generate.builder.cfc.packing;

/**
 * Bottle.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/27/2019
 */
public class Bottle implements Packing {
    @Override
    public final String pack() {
        return "Bottle";
    }
}
