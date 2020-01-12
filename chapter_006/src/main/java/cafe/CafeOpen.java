package cafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CafeOpen.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/12/2020
 */
final class CafeOpen {
    /**
     * Constructor.
     */
    private CafeOpen() {
    }

    /**
     * Method to point in program.
     *
     * @param args args
     * @throws InterruptedException InterruptedException
     */
    public static void main(final String[] args) throws InterruptedException {
        final ExecutorService exec = Executors.newCachedThreadPool();
        final Cafe cafe = new Cafe(exec, 7);
        exec.execute(cafe);
        final int timeout = 200;
        TimeUnit.MILLISECONDS.sleep(timeout);
        exec.shutdownNow();
    }

}
