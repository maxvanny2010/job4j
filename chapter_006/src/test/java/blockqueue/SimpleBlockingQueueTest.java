package blockqueue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SimpleBlockingQueueTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 12/29/2019
 */
public class SimpleBlockingQueueTest {
    private Consumer consumer;
    private Producer producer;
    private SimpleBlockingQueue<Integer> queue;
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final String ln = System.lineSeparator();

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void setAfter() {
        this.queue = null;
        this.consumer = null;
        this.producer = null;
        System.setOut(System.out);
    }

    @Test
    public void whenCapacityIsOneAndOfferToOutOK() throws Exception {
        this.queue = new SimpleBlockingQueue<>(1);
        this.consumer = new Consumer(this.queue);
        this.producer = new Producer(this.queue, this.consumer);
        final Thread prod = new Thread(this.producer, "Producer");
        prod.start();
        prod.join();
        prod.interrupt();
        TimeUnit.MILLISECONDS.sleep(10);
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("sent:0")
                .append(ln)
                .append("get:0")
                .append(ln)
                .append("sent:1")
                .append(ln)
                .append("get:1")
                .append(ln)
                .append("sent:2")
                .append(ln)
                .append("get:2")
                .append(ln)
                .toString()
        ));
    }

    @Test
    public void whenCapacityIsOneAndOfferToListOK() throws Exception {
        this.queue = new SimpleBlockingQueue<>(2);
        this.consumer = new Consumer(this.queue);
        this.producer = new Producer(this.queue, this.consumer);
        final Thread prod = new Thread(this.producer, "Producer");
        prod.start();
        prod.join();
        prod.interrupt();
        final List<Integer> buffer = this.consumer.getBuffer();
        assertThat(buffer, is(Arrays.asList(0, 1, 2)));

    }
}
