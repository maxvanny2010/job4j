package cafe;

/**
 * Plate.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/12/2020
 */
class Plate {
    /**
     * field a order.
     */
    private final Order order;
    /**
     * field a food.
     */
    private final Food food;

    /**
     * Constructor.
     *
     * @param aOrder a order
     * @param aFood  a food
     */
    Plate(final Order aOrder, final Food aFood) {
        this.order = aOrder;
        this.food = aFood;
    }

    /**
     * Method to get.
     *
     * @return a order
     */
    final Order getOrder() {
        return this.order;
    }

    @Override
    public final String toString() {
        return this.food.toString();
    }
}
