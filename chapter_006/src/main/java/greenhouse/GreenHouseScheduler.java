package greenhouse;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * GreenHouseScheduler.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/13/2020
 */
class GreenHouseScheduler {
    /**
     * field a scheduler.
     */
    private static final ScheduledThreadPoolExecutor SCHEDULER =
            new ScheduledThreadPoolExecutor(4);
    /**
     * field a light.
     */
    private volatile boolean light = false;
    /**
     * field a water.
     */
    private volatile boolean water = false;
    /**
     * field a thermostat.
     */
    private String thermostat = "DAY";

    /**
     * Method to get.
     *
     * @return a light
     */
    @SuppressWarnings("unused")
    final synchronized boolean getLight() {
        return this.light;
    }

    /**
     * Method to set.
     *
     * @param aLight a light
     **/
    final void setLight(final boolean aLight) {
        this.light = aLight;
    }

    /**
     * Method to get.
     *
     * @return a water
     */
    @SuppressWarnings("unused")
    final synchronized boolean getWater() {
        return this.water;
    }

    /**
     * Method to set.
     *
     * @param aWater a water
     **/
    final void setWater(final boolean aWater) {
        this.water = aWater;
    }

    /**
     * Method to get.
     *
     * @return a scheduler
     */
    final ScheduledThreadPoolExecutor getScheduler() {
        return SCHEDULER;
    }

    /**
     * Method to get.
     *
     * @return a thermostat
     */
    @SuppressWarnings("unused")
    final synchronized String getThermostat() {
        return this.thermostat;
    }

    /**
     * Method to set.
     *
     * @param aThermostat aThermostat
     **/

    final synchronized void setThermostat(final String aThermostat) {
        this.thermostat = aThermostat;
    }

    /**
     * Method to set scheduler.
     *
     * @param even  a even
     * @param delay a delay
     */
    final void scheduler(final Runnable even, final long delay) {
        SCHEDULER.schedule(even, delay, TimeUnit.MILLISECONDS);
    }

    /**
     * Method to set scheduler.
     *
     * @param even   a even
     * @param delay  a delay
     * @param period a period
     */
    final void repeat(final Runnable even,
                      final long delay, final long period) {
        SCHEDULER.scheduleAtFixedRate(even, delay, period,
                TimeUnit.MILLISECONDS);
    }
}
