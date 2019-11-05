package patterns.net.entity;

/**
 * EntityTwo.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/31/2019
 */
class EntityTwo {
    /**
     * field data.
     */
    private String data;

    /**
     * Method to set.
     *
     * @param aData data
     */
    final void setData(final String aData) {
        this.data = aData;
    }

    /**
     * Method to getter.
     * @return the data
     */
    final String getData() {
        return this.data;
    }
}
