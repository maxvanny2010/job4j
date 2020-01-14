package greenhouse;

/**
 * Bell.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/13/2020
 */
class Bell extends GreenHouseScheduler implements Runnable {
    @Override
    public final void run() {
        System.out.println("BING!");
    }
}
