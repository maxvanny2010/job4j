package collection;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * ConcurredArrayTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 12/28/2019
 */
public class ConcurredArrayTest {
    private final int size = 5;
    private final ConcurredArray<Integer> dynamic = new ConcurredArray<>(this.size);

    @Before
    public void setUpBefore() {
        this.dynamic.add(1);
        this.dynamic.add(2);
        this.dynamic.add(3);
    }

    @Test
    public void whenAddOK() {
        this.dynamic.add(4);
        var result = this.dynamic.get(3);
        assertThat(result, is(4));
    }

    @Test
    public void whenAddAndFullSize() {
        this.dynamic.add(4);
        this.dynamic.add(5);
        this.dynamic.add(6);
        this.dynamic.add(7);
        var result = this.dynamic.get(6);
        assertThat(result, is(7));
    }

    @Test
    public void whenGetOk() {
        var result = this.dynamic.get(0);
        assertThat(result, is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetOutIndexDown() {
        final Integer integer = this.dynamic.get(-1);
        assertNotNull(integer);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetOutIndexUp() {
        final Integer integer = this.dynamic.get(10);
        assertNotNull(integer);
    }

    @Test
    public void whenIteratorNext() {
        Iterator<Integer> iterator = this.dynamic.iterator();
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(1));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(2));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(3));
        assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorHasNextAfterModification() {
        Iterator<Integer> iterator = this.dynamic.iterator();
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(1));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(2));
        assertTrue(iterator.hasNext());
        assertThat(iterator.next(), is(3));
        this.dynamic.add(4);
        iterator.next();
    }

}


