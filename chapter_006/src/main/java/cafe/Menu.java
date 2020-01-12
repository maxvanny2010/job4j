package cafe;

import java.util.Random;

/**
 * Menu.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/12/2020
 */
enum Menu {
    /**
     * field a menu water.
     */
    BREAKFAST(new Food(new String[]{"break", "bread"})),
    /**
     * field a menu water.
     */
    DINNER(new Food(new String[]{"dinner", "bread"})),
    /**
     * field a menu water.
     */
    LUNCH(new Food(new String[]{"lunch", "bread"})),
    /**
     * field a menu water.
     */
    WATER(new Food(new String[]{"water", "bread"}));
    /**
     * field a food.
     */
    private final Food food;

    /**
     * Constructor.
     *
     * @param aFood food
     */
    Menu(final Food aFood) {
        this.food = aFood;
    }

    /**
     * Method to get.
     *
     * @return a food
     */
    final Food getFood() {
        return this.food;
    }

    /**
     * Method to get.
     *
     * @return a random menu
     *
     * @throws IllegalAccessException IllegalAccessException
     */
    final Food randomSelection() throws IllegalAccessException {
        final int index = new Random().nextInt(4);
        final Menu value = Menu.values()[index];
        if (value != null) {
            return value.getFood();
        }
        throw new IllegalAccessException();
    }
}
