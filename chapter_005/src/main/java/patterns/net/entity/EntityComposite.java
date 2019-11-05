package patterns.net.entity;

/**
 * EntityComposite.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/31/2019
 */
class EntityComposite {
    /**
     * field store.
     */
    private final EntityStore store = new EntityStore();

    /**
     * Setter.
     *
     * @param data1 data one
     * @param data2 data two
     */
    final void setData(final String data1, final String data2) {
        this.store.setData(data1, data2);
    }

    /**
     * Getter.
     *
     * @return the data by entity
     */
    final String[] getData() {
        return this.store.getData();
    }

}
