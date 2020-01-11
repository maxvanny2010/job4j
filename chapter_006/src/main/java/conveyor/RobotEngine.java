package conveyor;

/**
 * RobotEngine.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/11/2020
 */
class RobotEngine extends Robot {
    /**
     * Constructor.
     *
     * @param pool a pool
     */
    RobotEngine(final RobotPool pool) {
        super(pool);
    }

    /**
     * Method to do his work.
     */
    protected final void performService() {
        System.out.println("Installing engine");
        this.getAssembler().getCar().addEngine();
    }
}
