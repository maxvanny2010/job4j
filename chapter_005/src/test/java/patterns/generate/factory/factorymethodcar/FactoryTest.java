package patterns.generate.factory.factorymethodcar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static patterns.generate.factory.factorymethodcar.Factory.factory;

/**
 * FactoryTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/14/2019
 */
public class FactoryTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
    }


    @Test
    public void whenFactoryCreateToyotaCar() {
        final Models toyota = factory("Toyota");
        System.out.print(toyota.drive());
        assertThat(this.bos.toString(), is("Toyota to drive"));
    }

    @Test
    public void whenFactoryCreateAudiCar() {
        final Models audi = factory("Audi");
        System.out.print(audi.drive());
        assertThat(this.bos.toString(), is("Audi to drive"));
    }
}
