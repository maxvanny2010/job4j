package patterns.behavior.state.statewater;

/**
 * .
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/23/2019
 */
public enum WaterStates implements WaterState {
    /**
     * field solid.
     */
    SOLID_STATE {
        @Override
        public void changeState(final Water water) {
            water.setState(this);
        }
    },
    /**
     * field liquid.
     */
    LIQUID_STATE {
        @Override
        public void changeState(final Water water) {
            water.setState(this);
        }
    },
    /**
     * field vapor.
     */
    VAPOR_STATE {
        @Override
        public void changeState(final Water water) {
            water.setState(this);
        }
    }
}
