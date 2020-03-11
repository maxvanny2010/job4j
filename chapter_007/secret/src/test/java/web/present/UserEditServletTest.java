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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * UserEditServletTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/28/2020
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ActionAbs.class)
public class UserEditServletTest {
    User user0;
    User user1;
    User userNull;
    private Store<User> store;
    private Set<Integer> keeper;
    private @Mock
    HttpSession session;
    private @Mock
    HttpServletResponse resp;
    private @Mock
    HttpServletRequest req;
    private @Mock
    RequestDispatcher dispatcher;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.store = ActionStub.getStore();
        this.keeper = ActionStub.getKeeper();
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
        PowerMockito.when(ActionAbs.getKeeper()).thenReturn(ActionStub.getKeeper());
        when(this.req.getSession(false)).thenReturn(this.session);
    }

    @After
    public void tearDown() {
        this.store.clearStore();
        ActionStub.getKeeper().clear();
    }

    @Test
    public void whenEditedUserThenStoreItOK() throws ServletException, IOException {
        when(this.req.getParameter("id")).thenReturn("0");
        when(this.req.getParameter("login")).thenReturn("login_3");
        when(this.req.getParameter("name")).thenReturn("name_3");
        when(this.req.getParameter("email")).thenReturn("email_3");
        when(this.session.getAttribute("user"))
                .thenReturn(this.store.findById(0).orElse(this.userNull));
        final UserEditServlet servletEdit = new UserEditServlet();
        servletEdit.init();
        servletEdit.doPost(this.req, this.resp);
        final User user = this.store.findAll().iterator().next();
        assertThat(user.getId(), is(0));
        assertThat(user.getName(), is("name_3"));
        assertThat(user.getLogin(), is("login_3"));
        assertThat(user.getEmail(), is("email_3"));
    }

    @Test
    public void whenEditedUserThenStoreItNO() throws ServletException, IOException {
        when(this.req.getParameter("id")).thenReturn("0");
        when(this.req.getParameter("login")).thenReturn("login_1");
        when(this.req.getParameter("name")).thenReturn("#####");
        when(this.req.getParameter("email")).thenReturn("#####");
        when(this.session.getAttribute("user"))
                .thenReturn(this.store.findById(0).orElse(this.userNull));
        when(this.req.getRequestDispatcher(anyString()))
                .thenReturn(this.dispatcher);
        final UserEditServlet servletEdit = new UserEditServlet();
        servletEdit.init();
        servletEdit.doPost(this.req, this.resp);
        final User user = this.store.findAll().iterator().next();
        assertThat(user.getId(), is(0));
        assertThat(user.getName(), is("name_0"));
        assertThat(user.getLogin(), is("login_0"));
        assertThat(user.getEmail(), is("email_0"));
    }

    @Test
    public void whenSentToPageUserDataIsOK() throws ServletException, IOException {
        this.keeper.add(0);
        when(this.req.getParameter("id")).thenReturn("0");
        when(this.req.getRequestDispatcher(anyString()))
                .thenReturn(this.dispatcher);
        final UserEditServlet servletEdit = new UserEditServlet();
        servletEdit.init();
        servletEdit.doGet(this.req, this.resp);
        final String name = this.store.findAll().get(0).getName();
        assertThat(name, is("name_0"));
    }

    @Test
    public void whenSentToPageUserDataIsNO() throws ServletException, IOException {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        this.keeper.add(5);
        when(this.req.getParameter("id")).thenReturn("0");
        when(this.req.getRequestDispatcher(anyString()))
                .thenReturn(this.dispatcher);
        final UserEditServlet servletEdit = new UserEditServlet();
        servletEdit.init();
        servletEdit.doGet(this.req, this.resp);
        assertEquals(new StringBuilder()
                .append("Access is define")
                .append(System.lineSeparator())
                .toString(), bos.toString());
        System.setOut(System.out);
    }

    @Test
    public void whenSentToPageUserDataByObjectLoginIsNO()
            throws ServletException, IOException {
        this.keeper.add(0);
        this.keeper.add(1);
        when(this.req.getParameter("id")).thenReturn("0");
        when(this.req.getParameter("login")).thenReturn("login_1");
        when(this.session.getAttribute("user"))
                .thenReturn(this.store.findById(0).orElse(this.userNull));
        when(this.session.getAttribute("infoEdit"))
                .thenReturn(this.keeper.add(100));
        when(this.req.getRequestDispatcher(anyString()))
                .thenReturn(this.dispatcher);
        final UserEditServlet servletEdit = new UserEditServlet();
        servletEdit.init();
        servletEdit.doPost(this.req, this.resp);
        assertTrue(this.keeper.contains(100));
    }

    @Test
    public void whenSentToPageUserDataByLoginIsNO()
            throws ServletException, IOException {
        this.keeper.add(0);
        this.keeper.add(1);
        when(this.req.getParameter("id")).thenReturn("0");
        when(this.req.getParameter("login")).thenReturn("login_5");
        when(this.session.getAttribute("user"))
                .thenReturn(this.store.findById(0).orElse(this.userNull));
        when(this.session.getAttribute("infoEdit"))
                .thenReturn(this.keeper.add(100));
        when(this.req.getRequestDispatcher(anyString()))
                .thenReturn(this.dispatcher);
        final UserEditServlet servletEdit = new UserEditServlet();
        servletEdit.init();
        servletEdit.doPost(this.req, this.resp);
        assertTrue(this.keeper.contains(100));
    }

    @Test
    public void whenSentToPageUserDataByLoginAndUserLoginIsNO()
            throws ServletException, IOException {
        this.keeper.add(0);
        this.keeper.add(1);
        when(this.req.getParameter("id")).thenReturn("0");
        when(this.req.getParameter("login")).thenReturn("login_5");
        when(this.session.getAttribute("user"))
                .thenReturn(this.store.findById(5).orElse(this.userNull));
        when(this.session.getAttribute("infoEdit"))
                .thenReturn(this.keeper.add(100));
        when(this.req.getRequestDispatcher(anyString()))
                .thenReturn(this.dispatcher);
        final UserEditServlet servletEdit = new UserEditServlet();
        servletEdit.init();
        servletEdit.doPost(this.req, this.resp);
        assertTrue(this.keeper.contains(100));
    }

}
