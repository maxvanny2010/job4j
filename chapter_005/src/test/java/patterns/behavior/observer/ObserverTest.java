package patterns.behavior.observer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * StationTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/28/2019
 */
public class ObserverTest {
    private final Station station = new Station();
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final ObserverConsole obs = new ObserverConsole();

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
        this.station.addObserver(this.obs);
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
        this.station.getStation().clear();
    }

    @Test
    public void whenObserverOk() {
        final int temp = 25;
        final int pressure = 250;
        this.station.setMeasurements(temp, pressure);
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Temperature: 25  Pressure: 250\\n")
                .toString()));

    }

    @Test
    public void whenObserverDoubleOk() {
        final int temp1 = 25;
        final int temp2 = 50;
        final int pressure1 = 250;
        final int pressure2 = 500;
        this.station.setMeasurements(temp1, pressure1);
        this.station.setMeasurements(temp2, pressure2);
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Temperature: 25  Pressure: 250\\n")
                .append("Temperature: 50  Pressure: 500\\n")
                .toString()));
    }

    @Test
    public void whenObserverAddOk() {
        final int temp2 = 50;
        final int pressure2 = 500;
        final ObserverConsole obs2 = new ObserverConsole();
        this.station.addObserver(obs2);
        this.station.setMeasurements(temp2, pressure2);
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Temperature: 50  Pressure: 500\\n")
                .append("Temperature: 50  Pressure: 500\\n")
                .toString()));
    }

    @Test
    public void whenObserverRemoveOk() {
        final int temp1 = 25;
        final int temp3 = 60;
        final int pressure1 = 250;
        final int pressure3 = 600;
        final ObserverConsole obs2 = new ObserverConsole();
        this.station.addObserver(obs2);
        this.station.setMeasurements(temp1, pressure1);
        this.station.removeObserver(obs2);
        this.station.setMeasurements(temp3, pressure3);
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Temperature: 25  Pressure: 250\\n")
                .append("Temperature: 25  Pressure: 250\\n")
                .append("Temperature: 60  Pressure: 600\\n")
                .toString()));
    }

}
