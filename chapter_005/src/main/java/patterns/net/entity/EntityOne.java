package patterns.net.entity;

/**
 * EntityOne.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/31/2019
 */
class EntityOne {
    /**
     * field data.
     */
    private String data;

    /**
     * Method to getter.
     *
     * @return the data
     */
    final String getData() {
        return this.data;
    }

    /**
     * Method to set.
     *
     * @param aData data
     */
    final void setData(final String aData) {
        this.data = aData;
    }
}
