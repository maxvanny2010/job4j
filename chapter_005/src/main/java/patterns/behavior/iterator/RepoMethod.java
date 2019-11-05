package patterns.behavior.iterator;

import java.util.List;

/**
 * RepoMethod.
 *
 * @param <T> any extend Number
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/13/2019
 */
class RepoMethod<T extends Number> implements Container {
    /**
     * field list.
     */
    private final List<T> list;
    /**
     * field index.
     */
    private int index;

    /**
     * Constructor.
     *
     * @param aList list
     */
    RepoMethod(final List<T> aList) {
        this.list = aList;
    }

    /**
     * Method to get iterator for list.
     *
     * @return the iterator
     */
    @Override
    public final Iterator getIterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return list.size() > index;
            }

            @Override
            public T next() {
                if (!this.hasNext()) {
                    throw new UnsupportedOperationException();
                }
                return list.get(index++);
            }
        };
    }
}
