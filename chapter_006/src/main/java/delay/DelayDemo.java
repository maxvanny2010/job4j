package delay;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * DelayDemo.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/14/2020
 */
final class DelayDemo {
    /**
     * Constructor.
     */
    private DelayDemo() {
    }

    /**
     * Method to point the program.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        final int seed = 10;
        final int max = 600;
        final int min = 500;
        final Random random = new Random();
        final int exit = ThreadLocalRandom.current().nextInt(min + max);
        final ExecutorService executor = Executors.newCachedThreadPool();
        final DelayQueue<DelayTask> queue = new DelayQueue<>();
        IntStream.range(0, seed)
                .forEach(i -> queue.put(new DelayTask(random.nextInt(min))));
        queue.add(new DelayTask.EndSentinel(exit, executor));
        executor.execute(new DelayCustomer(queue));
    }
}
