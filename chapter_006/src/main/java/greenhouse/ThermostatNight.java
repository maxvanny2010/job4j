package greenhouse;

/**
 * ThermostatNight.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/13/2020
 */
class ThermostatNight extends GreenHouseScheduler implements Runnable {
    @Override
    public final void run() {
        System.out.println("Thermostat is Night setting");
        super.setThermostat("NIGHT");
    }
}
