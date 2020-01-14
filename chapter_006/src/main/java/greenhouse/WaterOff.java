package greenhouse;

/**
 * WaterOff.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/13/2020
 */
class WaterOff extends GreenHouseScheduler implements Runnable {
    @Override
    public final void run() {
        System.out.println("Water is OFF");
        super.setWater(false);
    }
}
