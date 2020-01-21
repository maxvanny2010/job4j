package patterns.behavior.iterator;

import java.util.List;

/**
 * RepoIter.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/13/2019
 */
public class RepoIter implements Iterator {
    /**
     * field  list.
     */
    private final List<Integer> list;
    /**
     * field index.
     */
    private int index;

    /**
     * Constructor.
     *
     * @param aList list
     */
    RepoIter(final List<Integer> aList) {
        this.list = aList;
    }

    @Override
    public final boolean hasNext() {
        return this.index < this.list.size();
    }

    @Override
    public final Object next() {
        if (!this.hasNext()) {
            throw new UnsupportedOperationException();
        }
        return this.list.get(this.index++);
    }
}
