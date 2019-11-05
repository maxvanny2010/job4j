package patterns.structure.decorator.decoratorprice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * DecoratorTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/24/2019
 */
public class DecoratorProductTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final Product milk = new Milk(50);

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
    }


    @Test
    public void whenDecoratorDiscount15is35() {
        final int price = new Decorator15(this.milk, 15).getPrice();
        System.out.printf("price is %s, and discount(15) is %d", this.milk.getPrice(), price);
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("price is 50, and discount(15) is 35")
                .toString()));
    }

    @Test
    public void whenDecoratorIsDoubleDiscount15is20() {
        final int price = new Decorator15(new Decorator15(this.milk, 15), 15).getPrice();
        System.out.printf("price is %s, and discount(15+15) is %d", this.milk.getPrice(), price);
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("price is 50, and discount(15+15) is 20")
                .toString()));
    }


}
