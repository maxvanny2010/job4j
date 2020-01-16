package cashbox;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * BankTellerSimulator.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/16/2020
 */
final class BankTellerSimulator {
    /**
     * Constructor.
     */
    private BankTellerSimulator() {
    }

    /**
     * Method a point to enter the program.
     *
     * @param args args
     * @throws InterruptedException InterruptedException
     **/
    public static void main(final String[] args) throws InterruptedException {
        final int maxLineSize = ThreadLocalRandom
                .current().nextInt(40, 50 + 1);
        final int adjustmentPeriod = ThreadLocalRandom
                .current().nextInt(200, 300 + 1);
        final ExecutorService exec = Executors.newCachedThreadPool();
        final CustomerLine customers = new CustomerLine(maxLineSize);
        exec.execute(new CustomerGenerator(customers));
        exec.execute(new TellerManager(exec, customers, adjustmentPeriod));
        final int rise = 5;
        TimeUnit.MILLISECONDS.sleep(adjustmentPeriod * rise);
        exec.shutdownNow();
    }
}
