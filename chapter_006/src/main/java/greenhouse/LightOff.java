package greenhouse;

/**
 * LightOff.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/13/2020
 */
class LightOff extends GreenHouseScheduler implements Runnable {
    @Override
    public final void run() {
        System.out.println("Light is OFF");
        super.setLight(false);
    }
}
