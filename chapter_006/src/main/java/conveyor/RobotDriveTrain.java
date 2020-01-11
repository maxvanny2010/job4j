package conveyor;

/**
 * RobotDriveTrain.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/11/2020
 */
class RobotDriveTrain extends Robot {
    /**
     * Constructor.
     *
     * @param pool a pool
     */
    RobotDriveTrain(final RobotPool pool) {
        super(pool);
    }

    /**
     * Method to do his work.
     */
    protected final void performService() {
        System.out.println("Installing drive train");
        this.getAssembler().getCar().addDriveTrain();
    }
}
