package list.circlelist;

import java.util.Objects;

/**
 * Node.
 *
 * @param <T> any T
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/28/2019
 */
public class NodeCircle<T> {
    /**
     * Method circle end.
     *
     * @param node any node
     * @return result
     */
    public final boolean hasCycle(final Node<T> node) {
        Objects.requireNonNull(node, "must not be null");
        Node<T> one = node;
        Node<T> two = node;

        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;
            if (one == two) {
                return true;
            }
        }
        return false;
    }

    /**
     * class Node<T>.
     *
     * @param <T> any T
     */
    public static class Node<T> {
        /**
         * field data.
         */
        @SuppressWarnings({"FieldCanBeLocal", "unused"})
        private final T data;
        /**
         * field Node.
         */
        private Node<T> next;

        /**
         * Constructor.
         *
         * @param aData data
         */
        Node(final T aData) {
            this.data = aData;
        }

        /**
         * Setter.
         *
         * @param aNext next node
         */
        public final void setNext(final Node<T> aNext) {
            this.next = aNext;
        }

    }
}
