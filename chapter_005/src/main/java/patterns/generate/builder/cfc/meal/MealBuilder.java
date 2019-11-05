package patterns.generate.builder.cfc.meal;

import patterns.generate.builder.cfc.burger.ChickenBurger;
import patterns.generate.builder.cfc.burger.VegBurger;
import patterns.generate.builder.cfc.drink.Coke;
import patterns.generate.builder.cfc.drink.Pepsi;

/**
 * MealBurger.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/27/2019
 */
public class MealBuilder {
    /**
     * field the meal.
     */
    private Meal meal;

    /**
     * Method to prepareVegMeal.
     *
     * @return meal
     */
    public final Meal prepareVegMeal() {
        this.meal = new Meal();
        this.meal.addItem(new VegBurger());
        this.meal.addItem(new Coke());
        return this.meal;
    }

    /**
     * Method to prepareNonVegMeal.
     *
     * @return meal
     */
    public final Meal prepareNonVegMeal() {
        this.meal = new Meal();
        this.meal.addItem(new ChickenBurger());
        this.meal.addItem(new Pepsi());
        return this.meal;
    }
}
