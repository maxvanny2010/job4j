package patterns.structure.adapters.adaptertrack.carwash;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import patterns.structure.adapters.adaptertrack.cars.Audi;
import patterns.structure.adapters.adaptertrack.cars.Cars;
import patterns.structure.adapters.adaptertrack.tracks.Tracks;
import patterns.structure.adapters.adaptertrack.tracks.Volvo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CarWashTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/24/2019
 */
public class CarWashTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final Cars audi = new Audi();
    private final Tracks volvo = new Volvo();

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
    }


    @Test
    public void whenCarWashAudiCar() {
        final CarWash wash = new CarWash(this.audi);
        wash.washCar();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("audi is clean")
                .append(System.lineSeparator())
                .toString()
        ));
    }

    @Test
    public void whenCarWashVolvoTrack() {
        final CarWash wash = new CarWash(new AdapterCarsTrack(this.volvo));
        wash.washCar();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("volvo is clean")
                .append(System.lineSeparator())
                .toString()
        ));
    }
}
