package patterns.generate.factory.factoryabs.abstractfactory;

import patterns.generate.factory.factoryabs.adidas.AdidasFactory;
import patterns.generate.factory.factoryabs.nike.NikeFactory;

/**
 * FactoryGenerator.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/25/2019
 */
final class FactoryGenerator {
    /**
     * Constructor.
     */
    private FactoryGenerator() {
    }

    /**
     * Method to get factory.
     *
     * @param factory the factory
     * @return the factory
     */

    static FactoryAbs getFactory(final String factory) {
        switch (factory.toLowerCase()) {
            case "adidas":
                return new AdidasFactory();
            case "nike":
                return new NikeFactory();
            default:
                return new FactoryNull();
        }
    }
}
