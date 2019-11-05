package patterns.net.entity;

/**
 * Client.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/31/2019
 */
class Client {
    /**
     * field composite.
     */
    private final EntityComposite composite = new EntityComposite();

    /**
     * Method to print.
     */
    final void printData() {
        for (int i = 0; i < this.composite.getData().length; i++) {
            System.out.println("Data: " + this.composite.getData()[i]);
        }
    }

    /**
     * Setter.
     *
     * @param data1 data one
     * @param data2 data two
     */
    final void setData(final String data1, final String data2) {
        this.composite.setData(data1, data2);
    }
}
