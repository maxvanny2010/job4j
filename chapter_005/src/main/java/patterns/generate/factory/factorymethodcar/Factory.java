package patterns.generate.factory.factorymethodcar;

/**
 * Factory.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/14/2019
 */
final class Factory {
    /**
     * Constructor.
     */
    private Factory() {
    }

    /**
     * Method to get a car which to driving.
     *
     * @param models model
     * @return to print a car.
     */
    static Models factory(final String models) {
        Models model = null;
        switch (models) {
            case "Toyota":
                model = new Toyota(models);
                break;
            case "Audi":
                model = new Audi(models);
                break;
            default:
                break;
        }
        return model;
    }
}
