package patterns.behavior.mediator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * MediatorTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/29/2019
 */
public class MediatorTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final MediatorConcrete mediator = new MediatorConcrete();

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
        final ColleagueConcrete one = new ColleagueConcrete(this.mediator, "one");
        this.mediator.addColleague(one);
        final ColleagueConcrete two = new ColleagueConcrete(this.mediator, "two");
        this.mediator.addColleague(two);
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
        this.mediator.getList().clear();
    }

    @Test
    public void whenObserverOk() {
        final ColleagueConcrete boss = new ColleagueConcrete(this.mediator, "boss");
        this.mediator.addColleague(boss);
        for (final ColleagueAbs coll : this.mediator.getList()) {
            System.out.println(coll.getName() + " " + coll.getLetter() + " " + coll.isStatus());
        }
        boss.sentRequest("WIN");
        for (final ColleagueAbs coll : this.mediator.getList()) {
            System.out.println(coll.getName() + " " + coll.getLetter() + " " + coll.isStatus());
        }
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("one null false")
                .append(System.lineSeparator())
                .append("two null false")
                .append(System.lineSeparator())
                .append("boss null false")
                .append(System.lineSeparator())
                .append("one WIN true")
                .append(System.lineSeparator())
                .append("two WIN true")
                .append(System.lineSeparator())
                .append("boss null false")
                .append(System.lineSeparator())
                .toString()));

    }
}
