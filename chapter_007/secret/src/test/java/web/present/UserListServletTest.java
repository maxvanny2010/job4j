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
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * UserListServletTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/28/2020
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ActionAbs.class)
public class UserListServletTest {
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
    @Mock
    private List<User> usersList;
    @Mock
    private Iterator<User> itrList;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.store = ActionStub.getStore();
        this.keeper = ActionStub.getKeeper();
        this.user0 = new User("name_0", "email_0",
                "login_0", "pass_0", new byte[0]);
        this.user1 = new User("name_1", "email_1",
                "login_1", "pass_1", new byte[0]);
        this.userNull = null;
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
    public void whenGetListUsersByUserOK()
            throws ServletException, IOException {
        this.keeper.add(0);
        final User users = this.store.findById(0).orElse(userNull);
        when(this.usersList.get(0)).thenReturn(users);
        when(this.session.getAttribute("role")).thenReturn("user");
        when(this.session.getAttribute("user")).thenReturn(users);
        when(this.req.getRequestDispatcher(anyString()))
                .thenReturn(this.dispatcher);
        final UserListServlet servletList = new UserListServlet();
        servletList.init();
        servletList.doGet(this.req, this.resp);
        final User user = this.usersList.get(0);
        assertEquals(user.toString(), new StringBuilder()
                .append("User")
                .append("[id=0, ")
                .append("createTime='")
                .append(this.store.findAll().get(0).getCreateTime())
                .append("', ")
                .append("name='name_0', ")
                .append("email='email_0', ")
                .append("login='login_0', ")
                .append("password='pass_0']")
                .toString());
    }

    @Test
    public void whenGetListOfUsersByAdminOK() throws ServletException, IOException {
        when(this.usersList.size()).thenReturn(2);
        User user0 = this.store.findAll().get(0);
        User user1 = this.store.findAll().get(1);
        when(this.itrList.next()).thenReturn(user0).thenReturn(user1);
        when(this.usersList.iterator()).thenReturn(this.itrList);
        when(this.session.getAttribute("role")).thenReturn("admin");
        when(this.req.getRequestDispatcher(anyString()))
                .thenReturn(this.dispatcher);
        final UserListServlet servletList = new UserListServlet();
        servletList.init();
        servletList.doGet(this.req, this.resp);
        user0 = this.usersList.iterator().next();
        user1 = this.usersList.iterator().next();
        assertEquals(user0.toString(), new StringBuilder()
                .append("User")
                .append("[id=0, ")
                .append("createTime='")
                .append(this.store.findAll().get(0).getCreateTime())
                .append("', ")
                .append("name='name_0', ")
                .append("email='email_0', ")
                .append("login='login_0', ")
                .append("password='pass_0']")
                .toString());
        assertEquals(user1.toString(), new StringBuilder()
                .append("User")
                .append("[id=1, ")
                .append("createTime='")
                .append(this.store.findAll().get(1).getCreateTime())
                .append("', ")
                .append("name='name_1', ")
                .append("email='email_1', ")
                .append("login='login_1', ")
                .append("password='pass_1']")
                .toString());
    }

    @Test
    public void whenGetEmptyListOfUserByByAdminOK()
            throws ServletException, IOException {
        when(this.usersList.size()).thenReturn(0);
        when(this.itrList.next()).thenReturn(this.userNull);
        when(this.usersList.iterator()).thenReturn(this.itrList);
        when(this.session.getAttribute("role")).thenReturn("admin");
        when(this.session.getAttribute("user")).thenReturn(this.userNull);
        when(this.req.getRequestDispatcher(anyString()))
                .thenReturn(this.dispatcher);
        final UserListServlet servletList = new UserListServlet();
        servletList.init();
        servletList.doGet(this.req, this.resp);
        final User user0 = this.usersList.iterator().next();
        assertTrue(Optional.ofNullable(user0).isEmpty());
    }

}
