package patterns.generate.builder.cfc.item;

import patterns.generate.builder.cfc.packing.Packing;

/**
 * Item.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/27/2019
 */
public interface Item {
    /**
     * Method name.
     *
     * @return name
     */
    String name();

    /**
     * Method to packing.
     *
     * @return packing
     */
    Packing packing();

    /**
     * Method to price.
     *
     * @return price
     */
    float price();
}
