package patterns.generate.builder.cfc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import patterns.generate.builder.cfc.meal.Meal;
import patterns.generate.builder.cfc.meal.MealBuilder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * BuilderMealBurgerTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/27/2019
 */
public class BuilderMealBuilderTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final MealBuilder mealBuilder = new MealBuilder();
    private final String ls = System.lineSeparator();


    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
    }


    @Test
    public void whenVegMealBuilder() {
        final Meal vegMeal = mealBuilder.prepareVegMeal();
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Item : Veg Burger, Packing : Wrapper, Price : 25.0")
                .append(this.ls)
                .append("Item : Coke, Packing : Bottle, Price : 30.0")
                .append(this.ls)
                .append("Total Cost: 55.0")
                .append(this.ls)
                .toString()
        ));
    }

    @Test
    public void whenNonVegMalBuilder() {
        final Meal vegMeal = mealBuilder.prepareNonVegMeal();
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Item : Chicken Burger, Packing : Wrapper, Price : 50.5")
                .append(this.ls)
                .append("Item : Pepsi, Packing : Bottle, Price : 35.0")
                .append(this.ls)
                .append("Total Cost: 85.5")
                .append(this.ls)
                .toString()
        ));
    }
}
