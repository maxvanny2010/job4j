package emailmap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * EmailTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/3/2019
 */
public class EmailTest {
    private final Email email = new Email();
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
        User user1 = new User();
        user1.setEmail("xxx@ya.ru");
        user1.setEmail("foo@gmail.com");
        user1.setEmail("lol@mail.ru");
        User user2 = new User();
        user2.setEmail("foo@gmail.com");
        user2.setEmail("ups@pisem.net");
        User user3 = new User();
        user3.setEmail("xyz@pisem.net");
        user3.setEmail("vasya@pupkin.com");
        User user4 = new User();
        user4.setEmail("ups@pisem.net");
        user4.setEmail("aaa@bbb.ru");
        User user5 = new User();
        user5.setEmail("xyz@pisem.net");
        this.email.addToMap("user1", user1.getEmails());
        this.email.addToMap("user2", user2.getEmails());
        this.email.addToMap("user3", user3.getEmails());
        this.email.addToMap("user4", user4.getEmails());
        this.email.addToMap("user5", user5.getEmails());
    }

    @After
    public void unloadOut() {
        System.setOut(System.out);
    }

    @Test
    public void whenGetEmailsOk() {
        this.email.clearEmails();
        this.email.infoMap(this.email.getMap());
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("user3: [vasya@pupkin.com, xyz@pisem.net]\n")
                .append("user4: [aaa@bbb.ru, ups@pisem.net, lol@mail.ru, xxx@ya.ru, foo@gmail.com]\n")
                .toString()));
    }

    @Test
    public void addToMap() {
        this.email.infoMap(this.email.getMap());
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("user1: [lol@mail.ru, xxx@ya.ru, foo@gmail.com]\n")
                .append("user2: [ups@pisem.net, foo@gmail.com]\n")
                .append("user5: [xyz@pisem.net]\n")
                .append("user3: [vasya@pupkin.com, xyz@pisem.net]\n")
                .append("user4: [aaa@bbb.ru, ups@pisem.net]\n")
                .toString()));
    }

    @Test
    public void whenInfoMap() {
        this.email.infoMap(this.email.getMap());
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("user1: [lol@mail.ru, xxx@ya.ru, foo@gmail.com]\n")
                .append("user2: [ups@pisem.net, foo@gmail.com]\n")
                .append("user5: [xyz@pisem.net]\n")
                .append("user3: [vasya@pupkin.com, xyz@pisem.net]\n")
                .append("user4: [aaa@bbb.ru, ups@pisem.net]\n")
                .toString()));

    }
}
