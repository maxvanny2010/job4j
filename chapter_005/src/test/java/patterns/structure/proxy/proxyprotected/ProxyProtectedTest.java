package patterns.structure.proxy.proxyprotected;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import patterns.structure.proxy.proxyprotected.access.AccessProxy;
import patterns.structure.proxy.proxyprotected.users.User;
import patterns.structure.proxy.proxyprotected.users.UserGuest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ProxyProtectedTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/23/2019
 */
public class ProxyProtectedTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final User user = new User("user");
    private final User admin = new User("admin");
    private final UserGuest guest = new UserGuest("guest");


    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
    }


    @Test
    public void whenApplyUserHaveProxy() {
        new AccessProxy(this.user).access();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Access to apply: user")
                .append("\n")
                .toString()
        ));
    }

    @Test
    public void whenApplyAdminHaveProxy() {
        new AccessProxy(this.admin).access();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Access to apply: admin")
                .append("\n")
                .toString()
        ));
    }

    @Test
    public void whenNoApplyGuestHaveProxy() {
        new AccessProxy(this.guest).access();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Access no apply: guest")
                .append("\n")
                .toString()
        ));
    }


}
