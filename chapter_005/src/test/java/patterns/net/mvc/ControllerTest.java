package patterns.net.mvc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ControllerTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/31/2019
 */
public class ControllerTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final Student model = this.receivedStudentFromDatabase();
    private final View view = new View();
    private final Controller controller = new Controller(this.model, this.view);

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
    }


    @Test
    public void whenControllerStart() {
        this.controller.updateView();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Student: ")
                .append(System.lineSeparator())
                .append("Name: Robert")
                .append(System.lineSeparator())
                .append("Id: 10")
                .append(System.lineSeparator())
                .toString())
        );
    }

    @Test
    public void whenControllerSetNewName() {
        this.controller.updateView();
        this.controller.setStudentName("John");
        this.controller.setStudentId("11");
        this.controller.updateView();
        this.controller.setStudentName("Bred");
        this.controller.setStudentId("12");
        this.controller.updateView();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Student: ")
                .append(System.lineSeparator())
                .append("Name: Robert")
                .append(System.lineSeparator())
                .append("Id: 10")
                .append(System.lineSeparator())
                .append("Student: ")
                .append(System.lineSeparator())
                .append("Name: John")
                .append(System.lineSeparator())
                .append("Id: 11")
                .append(System.lineSeparator())
                .append("Student: ")
                .append(System.lineSeparator())
                .append("Name: Bred")
                .append(System.lineSeparator())
                .append("Id: 12")
                .append(System.lineSeparator())
                .toString())
        );
    }

    private Student receivedStudentFromDatabase() {
        final Student student = new Student();
        student.setName("Robert");
        student.setId("10");
        return student;
    }

}
