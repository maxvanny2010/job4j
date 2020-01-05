package store.user;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import store.exception.StoreException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * UserStoreTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 12/27/2019
 */
public class UserStoreTest {

    private UserStore userStore;
    private User user;

    @Before
    public void setBefore() {
        this.userStore = new UserStore();
        this.user = new User(10);
        this.userStore.add(this.user);
    }

    @After
    public void setAfter() {
        this.userStore.getStore().clear();
        this.userStore = null;
        Atomic.ATOMIC_INTEGER.set(0);
    }

    @Test
    public void whenAddOk() {
        final int res = this.userStore.getStore().get(0).getAmount();
        final int exp = 10;
        assertEquals(exp, res);
    }

    @Test
    public void whenAddFalls() {
        final boolean two = this.userStore.add(this.user);
        assertFalse(two);
    }

    @Test
    public void whenUpdateOk() {
        this.user.plusAmount(10);
        final boolean result = this.userStore.update(this.user);
        final int res = this.userStore.getStore().get(0).getAmount();
        final int exp = 20;
        assertTrue(result);
        assertEquals(exp, res);
    }

    @Test
    public void whenUpdateFall() {
        final boolean result = this.userStore.update(new User(0));
        assertFalse(result);
    }

    @Test
    public void whenDeleteOk() {
        final User two = new User(0);
        this.userStore.add(two);
        final int size = this.userStore.getStore().size();
        assertEquals(2, size);
        final boolean result = this.userStore.delete(two);
        assertTrue(result);
    }

    @Test
    public void whenDeleteFall() {
        final User two = new User(0);
        final boolean result = this.userStore.delete(two);
        assertFalse(result);
    }

    @Test
    public void whenTransferOk() {
        final int amount = 10;
        final boolean result = this.userStore.add(new User(amount));
        final int src = this.userStore.getStore().get(0).getId();
        final int dst = this.userStore.getStore().get(1).getId();
        this.userStore.transfer(src, dst, amount);
        final int resSrc = this.userStore.getStore().get(0).getAmount();
        final int resDst = this.userStore.getStore().get(1).getAmount();
        final int expSrc = 0;
        final int expDst = 20;
        assertTrue(result);
        assertEquals(expDst, resDst);
        assertEquals(expSrc, resSrc);
    }

    @Test(expected = StoreException.class)
    public void whenTransferFallByAmount() {
        final int src = 0;
        final int dst = 1;
        final int amount = 100;
        this.userStore.add(new User(amount));
        this.userStore.transfer(src, dst, amount);
    }

    @Test(expected = StoreException.class)
    public void whenTransferFallByIDDst() {
        final int src = 1;
        final int dst = 10;
        final int amount = 100;
        this.userStore.add(new User(amount));
        this.userStore.transfer(src, dst, amount);
    }

    @Test(expected = StoreException.class)
    public void whenTransferFallByISrc() {
        final int src = 10;
        final int dst = 1;
        final int amount = 100;
        this.userStore.add(new User(amount));
        this.userStore.transfer(src, dst, amount);
    }
}
