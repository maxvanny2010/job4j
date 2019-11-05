package patterns.generate.builder.cfc.burger;

import patterns.generate.builder.cfc.item.Item;
import patterns.generate.builder.cfc.packing.Packing;
import patterns.generate.builder.cfc.packing.Wrapper;

/**
 * Burger.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/27/2019
 */
public abstract class Burger implements Item {

    @Override
    public final Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
