package collection;

import list.dynamicarray.DynamicArray;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;

/**
 * collection.collection.
 *
 * @param <T> T
 * @author Maxim Vanny
 * @version 5.0
 * @since 12/28/2019
 */
@ThreadSafe
class ConcurredArray<T> implements Iterable<T> {
    /**
     * field array.
     */
    @GuardedBy("this")
    private final DynamicArray<T> array;

    /**
     * Constructor.
     *
     * @param size size
     */
    ConcurredArray(final int size) {
        this.array = new DynamicArray<>(size);
    }

    /**
     * Method to add.
     *
     * @param value value
     */
    final synchronized void add(final T value) {
        this.array.add(value);
    }

    /**
     * Method to get.
     *
     * @param index index.
     * @return element from container.
     */
    final synchronized T get(final int index) {
        return this.array.get(index);
    }

    /**
     * Method to get.
     *
     * @return iterator
     */
    @Override
    public final synchronized Iterator<T> iterator() {
        return copy(this.array).iterator();
    }

    /**
     * Method copy.
     *
     * @param src src for copy
     * @return array by list
     */
    private DynamicArray<T> copy(final DynamicArray<T> src) {
        final int size = 10;
        final DynamicArray<T> dynamic = new DynamicArray<>(size);
        src.forEach(dynamic::add);
        return dynamic;
    }
}
