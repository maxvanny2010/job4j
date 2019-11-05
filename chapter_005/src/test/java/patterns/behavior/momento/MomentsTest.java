package patterns.behavior.momento;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * MomentsTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/29/2019
 */
public class MomentsTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final MomentsCoordinator coordinator = new MomentsCoordinator();
    private final MomentsStore store = new MomentsStore();

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
    }

    @Test
    public void whenObserverOk() {
        this.coordinator.setState("one");
        this.store.setMoment(this.coordinator.createMoment());
        this.coordinator.setState("two");
        this.coordinator.getStateFromMoment(this.store.getMoment());
        System.out.println(this.coordinator.getState());
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("one")
                .append(System.lineSeparator())
                .toString()));

    }

}
