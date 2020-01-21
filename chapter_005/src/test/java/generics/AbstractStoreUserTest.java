package generics;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AbstractStoreUserTest {
    private AbstractStore<User> abstractStore = new UserStore(4);
    private User one;
    @SuppressWarnings("FieldCanBeLocal")
    private User two;
    @SuppressWarnings("FieldCanBeLocal")
    private User three;
    private User four;

    @Before
    public void beforeAction() {
        one = new User("1");
        two = new User("2");
        three = new User("3");
        four = new User("4");

        this.abstractStore.add(one);
        this.abstractStore.add(two);
        this.abstractStore.add(three);
    }

    @Test
    public void addOK() {
        this.abstractStore.add(four);
        var result = this.abstractStore.findById("4");
        assertThat(result, is(four));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addIfSizeOutNEE() {
        this.abstractStore.add(this.four);
        this.abstractStore.add(this.four);
    }

    @Test
    public void replaceOK() {
        this.abstractStore.replace("1", this.four);
        var result = this.abstractStore.findById("4");
        assertThat(result, is(this.four));
    }

    @Test(expected = NoSuchElementException.class)
    public void replaceByNotExistIdNEE() {
        this.abstractStore.replace("5", null);
    }

    @Test(expected = NoSuchElementException.class)
    public void removeOK() {
        this.abstractStore.delete("1");
        var result = this.abstractStore.findById("1");
        assertThat(result, is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void deleteIfNullOutOfSizeNEE() {
        this.abstractStore.delete("4");
    }

    @Test(expected = NoSuchElementException.class)
    public void deleteIfNoIdNEE() {
        this.abstractStore.delete("10");
    }

    @Test
    public void findByIdOK() {
        var result = this.abstractStore.findById("1");
        assertThat(result, is(one));
    }

    @Test(expected = NoSuchElementException.class)
    public void findIfIdOutSizeNEE() {
        this.abstractStore.findById("5");
    }

    @Test(expected = NoSuchElementException.class)
    public void findIfIdNullNEE() {
        this.abstractStore.findById("4");
    }

    @Test(expected = NoSuchElementException.class)
    public void findIfIdEmptyNEE() {
        this.abstractStore = new UserStore(0);
        this.abstractStore.findById("0");
    }
}


