package pool;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ThreadPoolTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/4/2020
 */
public class ThreadPoolTest {
    private ThreadPool pool;
    private List<Integer> result = new ArrayList<>();

    @Before
    public void setBefore() {
        final int capacity = new Random().nextInt(1) + 1;
        this.pool = new ThreadPool(capacity);
        this.pool.startPool();
    }

    @After
    public void setAfter() {
        this.pool = null;
        this.result = null;
    }

    @Test
    public void whenAddRunnableToPollIsOk() throws InterruptedException {
        IntStream.range(0, 3).forEach(i -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            this.pool.work(() -> this.result.add(i));
        });
        this.pool.shutdown();
        waitWhenPollIsAlive();
        assertThat(this.result.toString(), is(List.of(0, 1, 2).toString()));
    }

    @Test
    public void testShutdown() throws InterruptedException {
        IntStream.range(0, 3).forEach(i -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            this.pool.work(() -> this.result.add(i));
        });
        this.pool.shutdown();
        waitWhenPollIsAlive();
        Assert.assertFalse(false);
    }

    private void waitWhenPollIsAlive() throws InterruptedException {
        while (true) {
            final boolean result = this.pool
                    .getListThreads().stream().anyMatch(Thread::isAlive);
            if (!result) {
                break;
            }
            TimeUnit.MILLISECONDS.sleep(10);
        }
    }
}


