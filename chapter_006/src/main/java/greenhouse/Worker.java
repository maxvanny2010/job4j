package greenhouse;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Worker.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/13/2020
 */
final class Worker {
    /**
     * Constructor.
     */
    private Worker() {
    }

    /**
     * Method to point in program.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        final GreenHouseScheduler gh = new GreenHouseScheduler();
        final int min = 700;
        final int max = 801;
        final int delay = ThreadLocalRandom.current().nextInt(min, max);
        final int period = 20;
        final int period1 = 50;
        final int period2 = 40;
        final int period3 = 5;
        final int period4 = 10;
        final int period5 = 12;
        gh.scheduler(new Terminate(), delay);
        gh.repeat(new Bell(), 0, period);
        gh.repeat(new ThermostatNight(), 0, period1);
        gh.repeat(new ThermostatDay(), 0, period2);
        gh.repeat(new LightOn(), 0, period3);
        gh.repeat(new LightOff(), 0, period4);
        gh.repeat(new WaterOn(), 0, period3);
        gh.repeat(new WaterOff(), 0, period5);
        gh.repeat(new CollectData(), period1, period1);
    }

}
