package patterns.structure.adapters.adaptertrack.cars;

/**
 * Audi.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/24/2019
 */
public class Audi implements Cars {
    @Override
    public final void wash() {
        System.out.println("audi is clean");
    }
}
