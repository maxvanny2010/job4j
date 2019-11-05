package patterns.net.entity;

/**
 * EntityStore.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/31/2019
 */
class EntityStore {
    /**
     * field one.
     */
    private final EntityOne one = new EntityOne();
    /**
     * field two.
     */
    private final EntityTwo two = new EntityTwo();

    /**
     * Setter.
     *
     * @param data1 data one
     * @param data2 data two
     */
    final void setData(final String data1, final String data2) {
        this.one.setData(data1);
        this.two.setData(data2);
    }

    /**
     * Getter.
     *
     * @return the data by entity
     */
    final String[] getData() {
        return new String[]{this.one.getData(), this.two.getData()};
    }
}
