package web.present;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * AllServletTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/28/2020
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                UserDeleteServletTest.class,
                UserEditServletTest.class,
                UserListServletTest.class
        }
)
public class AllServletTest {

}
