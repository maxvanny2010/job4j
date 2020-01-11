package blockqueue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TestBlock.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 12/30/2019
 */
public class BlockingQueueTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private CopyOnWriteArrayList<Integer> buffer;
    private SimpleBlockingQueue<Integer> queue;

    @Before
    public void setBefore() {
        final int capacity = new Random().nextInt(1) + 1;
        this.queue = new SimpleBlockingQueue<>(capacity);
        this.buffer = new CopyOnWriteArrayList<>();
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void setAfter() {
        System.setOut(System.out);
    }

    @Test
    public void whenProducerConsumerOk() throws InterruptedException {
        final Thread consumer = new Thread(() -> {
            while (this.queue.size() != 0 || !Thread.currentThread().isInterrupted()) {
                try {
                    this.buffer.add(this.queue.poll());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        final Thread producer = new Thread(() -> {
            IntStream.range(0, 3).forEach(i -> {
                        try {
                            this.queue.offer(i);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            );
            consumer.interrupt();
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        assertThat(this.buffer, is(Arrays.asList(0, 1, 2)));
    }

}
