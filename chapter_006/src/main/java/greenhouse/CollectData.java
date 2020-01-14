package greenhouse;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * CollectData.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/13/2020
 */
class CollectData extends GreenHouseScheduler implements Runnable {
/**
 * field a temp value.
 */
    public static final float TEMP = 65.0f;
    /**
     * field a interval time.
     */
    private final int min = 30;
    /**
     * field a data list.
     */
    static final  List<DataPoint> DATA =
            Collections.synchronizedList(new ArrayList<>());
    /**
     * field a random.
     */
    private final Random random = new Random(this.min);
    /**
     * field a calendar.
     */
    private final Calendar lastTime = Calendar.getInstance();
    /**
     * field a last temperature.
     */
    private float lastTemp = TEMP;
    /**
     * field a temperature direction.
     */
    private int tempDirection = +1;

    @Override
    public final void run() {
        final int limit = 4;
        final int bound = 5;
        synchronized (GreenHouseScheduler.class) {
            this.lastTime.set(Calendar.MINUTE,
                    this.lastTime.get(Calendar.MINUTE) + this.min);
            if (this.random.nextInt(bound) == limit) {
                this.tempDirection = -this.tempDirection;
                this.lastTemp += this.tempDirection
                        * (1.0f + this.random.nextFloat());
            }
            DATA.add(new DataPoint((Calendar) this.lastTime.clone(),
                    this.lastTemp));
        }
    }
}
