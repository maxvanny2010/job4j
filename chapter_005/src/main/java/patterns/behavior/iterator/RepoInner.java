package patterns.behavior.iterator;

/**
 * Repo.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/13/2019
 */
public class RepoInner implements Container {
    /**
     * field array the repo.
     */
    private final String[] names = {"A", "B", "C", "D"};
    @SuppressWarnings("unused")
    @Override
    public final Iterator getIterator() {
        return new IteratorSimple();
    }

    /**
     * Repo.
     *
     * @author Maxim Vanny
     * @version 5.0
     * @since 10/13/2019
     */
    private class IteratorSimple implements Iterator {
        /**
         * field index.
         */
        private int index;

        @Override
        public final boolean hasNext() {
            return this.index < names.length;
        }

        @Override
        public final Object next() {
            if (!this.hasNext()) {
                throw new IllegalStateException();
            }
            return names[index++];
        }
    }
}
