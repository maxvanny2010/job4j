package singleton;

import org.junit.Assert;
import org.junit.Test;

/**
 * SingletonClassTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/3/2020
 */
public class SingletonClassTest {

    @Test
    public void testGetInstance() {
        final SingletonClass result1 = SingletonClass.getInstance();
        final SingletonClass result2 = SingletonClass.getInstance();
        Assert.assertEquals(result1,result2);
    }
}


