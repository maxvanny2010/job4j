package ua.nino.logic.action;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ua.nino.model.auto.Auto;
import ua.nino.model.auto.Brands;
import ua.nino.model.auto.Colors;
import ua.nino.model.auto.Engines;
import ua.nino.model.auto.Models;
import ua.nino.model.auto.Years;
import ua.nino.model.user.User;
import ua.nino.persistence.dao.store.UserStore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.when;
import static ua.nino.logic.action.ActionAbs.getAdmin;
import static ua.nino.logic.action.ActionAbs.getAds;
import static ua.nino.logic.action.ActionAbs.getAuto;
import static ua.nino.logic.action.ActionAbs.getUser;
import static ua.nino.logic.action.ActionAbs.idxAdmin;
import static ua.nino.logic.action.ActionAbs.idxAds;
import static ua.nino.logic.action.ActionAbs.idxUser;

/**
 * ActionUploadAdsTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/28/2020
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ActionAbs.class)
public class ActionUploadAdsTest {
    @SuppressWarnings("FieldCanBeLocal")
    private User user0;
    @SuppressWarnings("FieldCanBeLocal")
    private User user1;
    @SuppressWarnings("FieldCanBeLocal")
    private User userNull;
    private UserStore store;
    @Mock
    private HttpSession session;
    @Mock
    private HttpServletRequest req;
    @Mock
    private HttpServletResponse resp;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.user0 = new User("name_0", "email_0",
                "login_0", "pass_0", "foto_0");
        this.user1 = new User("name_1", "email_1",
                "login_1", "pass_1", "foto_1");
        this.userNull = new User("NONE", "NONE",
                "NONE", "NONE", "foto_NONE");
        final Colors red = new Colors("red");
        final Brands bmw = new Brands("bmw");
        final Models bmw5 = new Models("5");
        final Years y2020 = new Years("2020");
        final Engines vol40 = new Engines("4.0");
        new Auto(bmw, bmw5, vol40, red, y2020);
        PowerMockito.mockStatic(ActionAbs.class);
        PowerMockito.when(getAdmin()).thenReturn(getAdmin());
        PowerMockito.when(getUser()).thenReturn(getUser());
        PowerMockito.when(getAds()).thenReturn(getAds());
        PowerMockito.when(getAuto()).thenReturn(getAuto());
        PowerMockito.when(idxAdmin()).thenReturn(idxAdmin());
        PowerMockito.when(idxUser()).thenReturn(idxUser());
        PowerMockito.when(idxAds()).thenReturn(idxAds());
        when(this.req.getSession(false)).thenReturn(this.session);
    }
}
