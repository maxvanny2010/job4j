package singleton;

import org.junit.Assert;
import org.junit.Test;

/**
 * SingletonFieldTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/3/2020
 */
public class SingletonFieldTest {
    @Test
    public void testGetInstance() {
        final SingletonField result1 = SingletonField.getInstance();
        final SingletonField result2 = SingletonField.getInstance();
        Assert.assertEquals(result1, result2);
    }
}


