package patterns.behavior.state.statewater;

/**
 * .
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/23/2019
 */
public class WaterVapor implements WaterState {
    @Override
    public final void changeState(final Water water) {
        water.setState(this);
    }

    @Override
    public final String toString() {
        return "water is vapor";
    }
}
