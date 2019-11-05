package patterns.behavior.command;

/**
 * OrderBuy.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/28/2019
 */
public class OrderBuy implements Order {
    /**
     * field stock.
     */
    private final Stock stock;

    /**
     * Constructor.
     *
     * @param aStock the stock
     */
    public OrderBuy(final Stock aStock) {
        this.stock = aStock;
    }

    @Override
    public final void execute() {
        this.stock.buy();
    }
}
