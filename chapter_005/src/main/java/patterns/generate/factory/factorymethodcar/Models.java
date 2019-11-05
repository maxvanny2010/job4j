package patterns.generate.factory.factorymethodcar;

/**
 * Models.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/14/2019
 */
abstract class Models implements Car {
    /**
     * field a model.
     */
    private final String model;

    /**
     * Constructor.
     *
     * @param aModel a model
     */
    Models(final String aModel) {
        this.model = aModel;
    }

    /**
     * Method to drive auto.
     *
     * @return drive auto
     */
    @Override
    public final String drive() {
        return this.getModel() + " to drive";
    }

    /**
     * Getter.
     *
     * @return a model
     */
    private String getModel() {
        return this.model;
    }
}
