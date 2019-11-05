package patterns.behavior.command;

/**
 * OrderSell.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/28/2019
 */
public class OrderSell implements Order {
    /**
     * field stock.
     */
    private final Stock stock;

    /**
     * Constructor.
     *
     * @param aStock the stock
     */
    public OrderSell(final Stock aStock) {
        this.stock = aStock;
    }

    @Override
    public final void execute() {
        this.stock.sell();
    }
}
