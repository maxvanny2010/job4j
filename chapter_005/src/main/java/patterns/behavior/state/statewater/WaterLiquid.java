package patterns.behavior.state.statewater;

/**
 * WaterLiquid.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/23/2019
 */
public class WaterLiquid implements WaterState {
    @Override
    public final void changeState(final Water water) {
        water.setState(this);
    }

    @Override
    public final String toString() {
        return "water is liquid";
    }
}
