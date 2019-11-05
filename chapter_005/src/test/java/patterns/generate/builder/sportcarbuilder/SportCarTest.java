package patterns.generate.builder.sportcarbuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SportCarTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/28/2019
 */
public class SportCarTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final String ls = System.lineSeparator();


    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
    }


    @Test
    public void whenBMWBuilder() {
        final int aMaxSpeed = 300;
        final SportCar car = new SportCar
                .Builder("BMW")
                .setColor("black")
                .setMaxSpeed(aMaxSpeed)
                .build();
        System.out.println(car.getName());
        System.out.println(car.getColor());
        System.out.print(car.getMaxSpeed());
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("BMW")
                .append(this.ls)
                .append("black")
                .append(this.ls)
                .append("300")
                .toString()
        ));
    }
    @Test
    public void whenMercedesBuilder() {
        final int aMaxSpeed = 400;
        final SportCar car = new SportCar
                .Builder("Mercedes")
                .setColor("black")
                .setMaxSpeed(aMaxSpeed)
                .build();
        System.out.println(car.getName());
        System.out.println(car.getColor());
        System.out.print(car.getMaxSpeed());
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Mercedes")
                .append(this.ls)
                .append("black")
                .append(this.ls)
                .append("400")
                .toString()
        ));
    }

}
