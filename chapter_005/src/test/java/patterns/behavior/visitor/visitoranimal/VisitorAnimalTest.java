package patterns.behavior.visitor.visitoranimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * VisitorAnimalTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/30/2019
 */
public class VisitorAnimalTest {
    private  IAnimal animal;
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
    }

    @Test
    public void whenVisitorDog() {
        this.animal = new Dog();
        this.animal.doJob(new VisitorConcrete());
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("gav")
                .append(System.lineSeparator())
                .toString()));
    }
    @Test
    public void whenVisitorCat() {
        this.animal = new Cat();
        this.animal.doJob(new VisitorConcrete());
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("may")
                .append(System.lineSeparator())
                .toString()));
    }


}
