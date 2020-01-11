package conveyor;

/**
 * RobotWheel.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/11/2020
 */
class RobotWheel extends Robot {
    /**
     * Constructor.
     *
     * @param pool a pool
     */
    RobotWheel(final RobotPool pool) {
        super(pool);
    }

    /**
     * Method to do his work.
     */
    protected final void performService() {
        System.out.println("Installing wheels");
        this.getAssembler().getCar().addWheels();
    }
}
