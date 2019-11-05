package patterns.structure.adapters.adaptertrack.tracks;

/**
 * Volvo.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/24/2019
 */
public class Volvo implements Tracks {
    @Override
    public final void clean() {
        System.out.println("volvo is clean");
    }
}
