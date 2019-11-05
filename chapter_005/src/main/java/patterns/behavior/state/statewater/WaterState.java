package patterns.behavior.state.statewater;

/**
 * WaterState.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/23/2019
 */
public interface WaterState {
    /**
     * Method to change a state water.
     *
     * @param water the water
     */
    void changeState(Water water);
}
