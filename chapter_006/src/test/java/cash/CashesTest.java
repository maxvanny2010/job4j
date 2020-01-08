package cash;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * CashesTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/1/2020
 */
public class CashesTest {
    private Cashes cache;
    private final Base base = new Base("base");

    @Before
    public void setBefore() {
        this.cache = new Cashes();
        this.cache.add(this.base);
    }

    @After
    public void setAfter() {
        Atomic.setAi(new AtomicInteger(0));
        this.cache = null;
    }

    @Test
    public void whenAddOk() throws InterruptedException {
        final Base one = new Base("one");
        final Runnable runnable = () -> this.cache.add(one);
        final Thread thread1 = new Thread(runnable);
        final Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        final int exp = 2;
        final int res = this.cache.size();
        final var result = this.cache.get(1);
        assertThat(res, is(exp));
        assertThat(result.getName(), is("one"));
    }

    @Test
    public void whenAddFall() throws InterruptedException {
        final AtomicReference<Base> add = new AtomicReference<>();
        final Runnable runnable = () -> add.set(this.cache.add(this.base));
        final Thread thread1 = new Thread(runnable);
        final Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        final int result = this.cache.size();
        final int expected = 1;
        assertThat(result, is(expected));
        assertNotNull(add.get());
    }

    @Test
    public void whenDeleteOK() throws InterruptedException {
        final Base one = new Base("one");
        this.cache.add(one);
        final Runnable runnable = () -> this.cache.delete(this.base);
        final Thread thread1 = new Thread(runnable);
        final Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        final int exp = 1;
        final int res = this.cache.size();
        final Base result = this.cache.get(one.getId());
        assertThat(res, is(exp));
        assertThat(result.getName(), is("one"));
    }

    @Test
    public void whenDeleteFall() throws InterruptedException {
        final Base one = new Base("one");
        final AtomicReference<Base> delete = new AtomicReference<>();
        final Runnable runnable = () -> delete.set(this.cache.delete(one));
        final Thread thread1 = new Thread(runnable);
        final Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        assertNull(delete.get());
    }

    @Test
    public void whenUpdateOK() throws InterruptedException {
        final Base tmp1 = this.cache.get(this.base.getId());
        final Base tmp2 = this.cache.get(this.base.getId());
        final Runnable runnable1 = () -> {
            tmp1.setName("one");
            this.cache.update(tmp1);
        };
        final Runnable runnable2 = () -> {
            tmp2.setName("two");
            this.cache.update(tmp2);
        };
        final Thread thread1 = new Thread(runnable1);
        final Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        final Base result = this.cache.get(this.base.getId());
        assertThat(result.getVersion(), is(2));
    }

    @Test
    public void whenUpdateFall() throws InterruptedException {
        final Base tmp1 = this.cache.get(this.base.getId());
        final Base tmp2 = new Base(0, 0, "fall");
        AtomicReference<Exception> ref = new AtomicReference<>();
        final Runnable runnable1 = () -> {
            tmp1.setName("one");
            try {
                this.cache.update(tmp1);
            } catch (Exception e) {
                ref.set(e);
            }
        };
        final Runnable runnable2 = () -> {
            try {
                this.cache.update(tmp2);
            } catch (Exception e) {
                ref.set(e);
            }
        };
        final Thread thread1 = new Thread(runnable1);
        final Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        Assert.assertThat(ref.get().getMessage(), is("OptimisticException"));
    }
}
