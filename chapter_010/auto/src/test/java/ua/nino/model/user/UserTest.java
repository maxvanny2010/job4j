package ua.nino.model.user;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static ua.nino.logic.action.ActionAbs.getAdmin;
import static ua.nino.logic.action.ActionAbs.getUser;
import static ua.nino.model.TestModelsAll.wrapper;

/**
 * UserTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/29/2020
 */
public class UserTest {

    @Test
    public void whenSaveUserOk() {
        wrapper(session -> {
            final User user = new User("test", "test", "test", "test", "test");
            final int id = getUser().save(user);
            final User result = getUser().getById(id);
            final User expected = new User("test", "test", "test", "test", "test");
            expected.setId(result.getId());
            assertEquals(expected, result);
        });
    }

    @Test
    public void whenUpdateUserOk() {
        wrapper(session -> {
            final User user = new User("test", "test", "test", "test", "test");
            final int id = getUser().save(user);
            final User tmp = getUser().getById(id);
            final User byId = getUser().getById(tmp.getId());
            byId.setName("NEW");
            getUser().update(byId);
            final String result = getUser().getById(tmp.getId()).getName();
            final String expected = "NEW";
            assertEquals(expected, result);
        });
    }

    @Test
    public void whenDeleteUserOk() {
        wrapper(session -> {
            final User user = new User("test", "test", "test", "test", "test");
            final User expected = new User("test", "test", "test", "test", "test");
            final int id = getUser().save(user);
            final User tmp = getUser().getById(id);
            expected.setId(id);
            assertEquals(expected, tmp);
            getUser().delete(tmp);
            final User result = getUser().getById(tmp.getId());
            assertNull(result);
        });
    }

    @Test
    public void whenFindAllUsersOk() {
        wrapper(session -> {
            final User user1 = new User("test", "test", "test", "test", "test");
            final User user2 = new User("test", "test", "test", "test", "test");
            getUser().save(user1);
            getUser().save(user2);
            final boolean isUser1 = getAdmin().findAllUsers().contains(user1);
            final boolean isUser2 = getAdmin().findAllUsers().contains(user1);
            assertTrue(isUser1);
            assertTrue(isUser2);
        });
    }

}
