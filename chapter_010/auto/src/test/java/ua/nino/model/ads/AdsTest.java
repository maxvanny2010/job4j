package ua.nino.model.ads;

import org.junit.Assert;
import org.junit.Test;
import ua.nino.model.user.User;

import static ua.nino.logic.action.ActionAbs.getUser;
import static ua.nino.model.TestModelsAll.wrapper;

/**
 * AdsTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/29/2020
 */
public class AdsTest {

    @Test
    public void whenSaveAdsOk() {
        wrapper(session -> {
            final User user = new User("test", "test", "test", "test", "test");
            final int id = getUser().save(user);
            final User result = getUser().getById(id);
            final User expected = new User("test", "test", "test", "test", "test");
            expected.setId(result.getId());
            Assert.assertEquals(expected, result);
        });
    }

}
