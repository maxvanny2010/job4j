package patterns.structure.fly.flyweight;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * FlyWeightTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/14/2019
 */
public class FlyWeightTest {
    private final FlyWeight fly = new FlyWeight();

    @Test
    public void whenMercedesTheSameOk() {
        final Mercedes red = this.fly.getMercedes("red");
        final Mercedes red1 = this.fly.getMercedes("red");
        final Mercedes green = this.fly.getMercedes("green");
        final Mercedes green1 = this.fly.getMercedes("green");
        assertEquals(red, red1);
        assertEquals(green, green1);
    }
}
