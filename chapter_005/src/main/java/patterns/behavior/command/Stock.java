package patterns.behavior.command;

/**
 * Stock.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/28/2019
 */
public class Stock {
    /**
     * field ticker.
     */
    private final String ticker;
    /**
     * field quantity.
     */
    private final int quantity;

    /**
     * Constructor.
     *
     * @param aTicker   the ticker
     * @param aQuantity the quantity
     */
    Stock(final String aTicker, final int aQuantity) {
        this.ticker = aTicker;
        this.quantity = aQuantity;
    }

    /**
     * Method to buy.
     */
    final void buy() {
        System.out.printf("\nStock [ Name: ] %s Quantity: %s ] bought",
                this.ticker, this.quantity);
    }

    /**
     * Method to sell.
     */
    final void sell() {
        System.out.printf("\nStock [ Name: ] %s Quantity: %s ] sold",
                this.ticker, this.quantity);
    }
}
