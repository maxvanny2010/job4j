package web.present;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import web.logic.action.ActionAbs;
import web.logic.stub.ActionStub;
import web.model.User;
import web.persistent.Store;
import web.persistent.StoreMemory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

/**
 * UserDeleteServletTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/28/2020
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ActionAbs.class)
public class UserDeleteServletTest {
    private User user0;
    private User user1;
    private User userNull;
    private Store<User> store;
    private @Mock
    HttpSession session;
    private @Mock
    HttpServletRequest req;
    private @Mock
    HttpServletResponse resp;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.store = StoreMemory.getInstance();
        this.user0 = new User("name_0", "email_0",
                "login_0", "pass_0", new byte[0]);
        this.user1 = new User("name_1", "email_1",
                "login_1", "pass_1", new byte[0]);
        this.userNull = new User("NONE", "NONE",
                "NONE", "NONE", new byte[0]);
        this.store.add(this.user0);
        this.store.add(this.user1);
        PowerMockito.mockStatic(ActionAbs.class);
        PowerMockito.when(ActionAbs.getStore()).thenReturn(ActionStub.getStore());
        when(this.req.getSession(false)).thenReturn(this.session);
    }

    @After
    public void tearDown() {
        this.store.clearStore();
    }


    @Test
    public void whenDeleteUserByAdminThenStoreItOK() throws ServletException, IOException {
        when(this.req.getParameter("id")).thenReturn("0");
        final User user0 = this.store.findById(0).orElse(this.userNull);
        when(this.session.getAttribute("role")).thenReturn("admin");
        when(this.session.getAttribute("user")).thenReturn(user0);
        final UserDeleteServlet servletDelete = new UserDeleteServlet();
        servletDelete.init();
        servletDelete.doPost(this.req, this.resp);
        final boolean isUserID = this.store.findAll().stream()
                .map(User::getId)
                .anyMatch(Integer.valueOf(0)::equals);
        assertFalse(isUserID);
    }

    @Test
    public void whenDeleteUserByAdminThenStoreItNO() throws ServletException, IOException {
        when(this.req.getParameter("id")).thenReturn("2");
        when(this.session.getAttribute("user"))
                .thenReturn(Optional.of(this.userNull).orElse(this.user0));
        when(this.session.getAttribute("role")).thenReturn("admin");
        final UserDeleteServlet servletDelete = new UserDeleteServlet();
        servletDelete.init();
        servletDelete.doPost(this.req, this.resp);
        final Integer[] isUserID = this.store.findAll().stream()
                .map(User::getId)
                .toArray(Integer[]::new);
        assertArrayEquals(isUserID, new Integer[]{0, 1});
    }

    @Test
    public void whenDeleteUserByUserThenStoreItOK() throws ServletException, IOException {
        when(this.req.getParameter("id")).thenReturn("1");
        final User user1 = this.store.findById(1).orElse(this.userNull);
        when(this.session.getAttribute("role")).thenReturn("user");
        when(this.session.getAttribute("user")).thenReturn(user1);
        final UserDeleteServlet servletDelete = new UserDeleteServlet();
        servletDelete.init();
        servletDelete.doPost(this.req, this.resp);
        final Integer[] isUserID = this.store.findAll().stream()
                .map(User::getId)
                .toArray(Integer[]::new);
        assertArrayEquals(isUserID, new Integer[]{0});
    }

    @Test
    public void whenDeleteUserByUserThenStoreItNO() throws ServletException, IOException {
        when(this.req.getParameter("id")).thenReturn("2");
        when(this.session.getAttribute("user"))
                .thenReturn(Optional.of(this.userNull).orElse(this.user1));
        when(this.session.getAttribute("role")).thenReturn("user");
        final UserDeleteServlet servletDelete = new UserDeleteServlet();
        servletDelete.init();
        servletDelete.doPost(this.req, this.resp);
        final Integer[] isUserID = this.store.findAll().stream()
                .map(User::getId)
                .toArray(Integer[]::new);
        assertArrayEquals(isUserID, new Integer[]{0, 1});
    }
}
