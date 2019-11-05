package patterns.generate.builder.cfc.meal;

import patterns.generate.builder.cfc.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Meal.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/27/2019
 */
public class Meal {
    /**
     * field a items.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Method to add the items.
     *
     * @param item the items
     */
    final void addItem(final Item item) {
        this.items.add(item);
    }

    /**
     * Method to get  a price.
     *
     * @return the price
     */
    public final float getCost() {
        float cost = 0.0f;
        for (Item item : this.items) {
            cost += item.price();
        }
        return cost;
    }

    /**
     * Method to show the items.
     */
    public final void showItems() {
        for (Item item : this.items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }
}
