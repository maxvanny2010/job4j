package patterns.generate.builder.cfc.drink;

import patterns.generate.builder.cfc.item.Item;
import patterns.generate.builder.cfc.packing.Bottle;
import patterns.generate.builder.cfc.packing.Packing;

/**
 * ColdDrink.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/27/2019
 */
public abstract class ColdDrink implements Item {

    @Override
    public final Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
