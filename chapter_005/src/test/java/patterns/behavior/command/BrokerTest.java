package patterns.behavior.command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * BrokerTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/28/2019
 */
public class BrokerTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final Stock stock = new Stock("AMEN", 100);
    private final Broker broker = new Broker();
    private final OrderBuy buy = new OrderBuy(this.stock);
    private final OrderSell sell = new OrderSell(this.stock);


    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
        this.broker.takeOrder(this.sell);
        this.broker.takeOrder(this.buy);
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
    }


    @Test
    public void whenBMWBuilder() {
        this.broker.placeOrder();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("\nStock [ Name: ] AMEN Quantity: 100 ] sold")
                .append("\nStock [ Name: ] AMEN Quantity: 100 ] bought")
                .toString()
        ));
    }

}
