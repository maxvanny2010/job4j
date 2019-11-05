package patterns.structure.fly.flyweightcolor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * FlyWeightFactoryTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/14/2019
 */
public class FlyWeightFactoryTest {
    private final FlyWeightFactory factory = new FlyWeightFactory();

    @Test
    public void whenCircleFillColor() {
        final Circle red = this.factory.getCircle("red");
        final Circle red1 = this.factory.getCircle("red");
        final Circle green = this.factory.getCircle("green");
        final Circle green1 = this.factory.getCircle("green");
        assertEquals(red, red1);
        assertEquals(green, green1);
    }
}
