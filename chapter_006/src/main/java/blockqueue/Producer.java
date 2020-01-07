package blockqueue;

import java.util.stream.IntStream;

/**
 * Producer.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 12/29/2019
 */
class Producer implements Runnable {
    /**
     * field queue.
     */
    private final SimpleBlockingQueue<Integer> queue;
    /**
     * field consumer.
     */
    private final Thread consumer;

    /**
     * Constructor.
     *
     * @param aQueue    queue
     * @param aConsumer consumer
     */
    Producer(final SimpleBlockingQueue<Integer> aQueue,
             final Consumer aConsumer) {
        this.queue = aQueue;
        this.consumer = new Thread(aConsumer, "Consumer");
        this.consumer.start();
    }

    @Override
    public final void run() {
        final int length = 3;
        IntStream.range(0, length).forEach(i -> {
                    try {
                        this.queue.offer(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        this.consumer.interrupt();
    }
}
