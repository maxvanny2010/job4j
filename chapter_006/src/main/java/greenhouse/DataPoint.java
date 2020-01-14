package greenhouse;

import java.util.Calendar;

/**
 * DataPoint.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/14/2020
 */
class DataPoint {
    /**
     * field a time.
     */
    private final Calendar time;
    /**
     * field a temperature.
     */
    private final float temp;

    /**
     * Constructor.
     *
     * @param aTime a time
     * @param aTemp a temperature
     */
    DataPoint(final Calendar aTime, final float aTemp) {
        this.time = aTime;
        this.temp = aTemp;
    }

    @Override
    public final String toString() {
        return this.time.getTime()
                + String.format(" temp: %1$.1f", this.temp);
    }
}
