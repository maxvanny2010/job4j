package actors;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * ActiveObject.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/16/2020
 */
class ActiveObject {
    /**
     * field a exec.
     */
    private final ExecutorService exec = Executors.newSingleThreadExecutor();
    /**
     * field a seed.
     */
    private final int seed = 50;
    /**
     * field a random.
     */
    private final Random random = new Random(this.seed);

    /**
     * Method to set pause.
     *
     * @param factor a factor
     */
    @SuppressWarnings("SameParameterValue")
    private void pause(final int factor) {
        try {
            TimeUnit.MILLISECONDS
                    .sleep(this.seed + random.nextInt(factor));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method calculate two int.
     *
     * @param x first int
     * @param y second int
     * @return sum
     */
    final Future<Integer> calculateInt(final int x, final int y) {
        return this.exec.submit(() -> {
            System.out.printf("start %d + %d\n", x, y);
            pause(seed);
            return x + y;
        });
    }

    /**
     * Method calculate two float.
     *
     * @param x first float
     * @param y second float
     * @return sum
     */
    final Future<Float> calculateFloat(final float x, final float y) {
        return this.exec.submit(() -> {
            System.out.printf("start %.1f + %.1f\n", x, y);
            pause(seed);
            return x + y;
        });
    }

    /**
     * Method to shutdown the executor.
     */
    final void shutdown() {
        this.exec.shutdown();
    }
}
