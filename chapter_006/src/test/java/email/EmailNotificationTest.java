package email;

import org.junit.Before;
import org.junit.Test;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * EmailNotificationTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/9/2020
 */
public class EmailNotificationTest {
    final EmailNotification sender = new EmailNotification();
    List<User> users;

    @Before
    public void setUp() {
        this.users = List.of(
                new User("Google", "google@.com"),
                new User("Sun", "sun@.com"),
                new User("Oracle", "oracle@.com")
        );
    }

    @Test
    public void whenClosePoolOk() {
        this.users.forEach(this.sender::emailTo);
        this.sender.close();
        assertTrue(this.sender.getPoll().isShutdown());
    }

    @Test
    public void whenEmailToMailboxByUserOk() {
        this.users.forEach(this.sender::emailTo);
        this.sender.close();
        final Map<String, Email> map = Receiver.getMap();
        final Email google = this.getExpectedEmail("google@.com");
        final Email sun = this.getExpectedEmail("sun@.com");
        final Email oracle = this.getExpectedEmail("oracle@.com");
        final List<Email> result = new ArrayList<>(map.values());
        assertEquals(this.users.size(), result.size());
        assertThat(result, containsInAnyOrder(google, sun, oracle));
    }


    private Email getExpectedEmail(@Nonnull final String level) {
        Email email;
        switch (level) {
            case "google@.com":
                email = new Email("Notification Google, email google@.com",
                        "Event for Google",
                        "google@.com");
                break;
            case "sun@.com":
                email = new Email("Notification Sun, email sun@.com",
                        "Event for Sun",
                        "sun@.com");
                break;
            case "oracle@.com":
                email = new Email("Notification Oracle, email oracle@.com",
                        "Event for Oracle",
                        "oracle@.com");
                break;
            default:
                email = null;
                break;
        }
        return email;
    }
}

