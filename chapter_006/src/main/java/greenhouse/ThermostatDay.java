package greenhouse;

/**
 * ThermostatDay.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/13/2020
 */
class ThermostatDay extends GreenHouseScheduler implements Runnable {
    @Override
    public final void run() {
        System.out.println("Thermostat is Day setting");
        super.setThermostat("DAY");
    }
}
