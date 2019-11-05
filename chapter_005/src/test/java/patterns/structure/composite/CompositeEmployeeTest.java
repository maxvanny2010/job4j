package patterns.structure.composite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CompositeEmployeeTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/25/2019
 */
public class CompositeEmployeeTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private Employee ceo;
    private Employee headSales;
    private Employee headMarketing;

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
        final int p10000 = 10000;
        final int p20000 = 20000;
        final int p300000 = 30000;
        this.ceo = new Employee("John", "ceo", p300000);
        this.headSales = new Employee("Robert", "Head Sales", p20000);
        this.headMarketing = new Employee("Michel", "Head Marketing", p20000);
        final Employee salesExecutive1 = new Employee("Richard", "Sales", p10000);
        final Employee salesExecutive2 = new Employee("Rob", "Sales", p10000);
        final Employee clerk1 = new Employee("Laura", "Marketing", p10000);
        final Employee clerk2 = new Employee("Bob", "Marketing", p10000);
        this.ceo.add(this.headSales);
        this.ceo.add(this.headMarketing);
        this.headSales.add(salesExecutive1);
        this.headSales.add(salesExecutive2);
        this.headMarketing.add(clerk1);
        this.headMarketing.add(clerk2);
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
    }


    @Test
    public void whenGetAllComposite() {
        for (final Employee head : this.ceo.getSubordinates()) {
            System.out.println(head);
            for (final Employee inner : head.getSubordinates()) {
                System.out.println(inner);
            }
        }
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Employee :[ Name : Robert, dept : Head Sales, salary :20000 ]")
                .append(System.lineSeparator())
                .append("Employee :[ Name : Richard, dept : Sales, salary :10000 ]")
                .append(System.lineSeparator())
                .append("Employee :[ Name : Rob, dept : Sales, salary :10000 ]")
                .append(System.lineSeparator())
                .append("Employee :[ Name : Michel, dept : Head Marketing, salary :20000 ]")
                .append(System.lineSeparator())
                .append("Employee :[ Name : Laura, dept : Marketing, salary :10000 ]")
                .append(System.lineSeparator())
                .append("Employee :[ Name : Bob, dept : Marketing, salary :10000 ]")
                .append(System.lineSeparator())
                .toString()));
    }

    @Test
    public void whenGetCeo() {
        System.out.println(this.ceo);
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Employee :[ Name : John, dept : ceo, salary :30000 ]")
                .append(System.lineSeparator())

                .toString()));
    }

    @Test
    public void whenGetHead() {
        for (final Employee headSales : this.ceo.getSubordinates()) {
            System.out.println(headSales);
        }
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Employee :[ Name : Robert, dept : Head Sales, salary :20000 ]")
                .append(System.lineSeparator())
                .append("Employee :[ Name : Michel, dept : Head Marketing, salary :20000 ]")
                .append(System.lineSeparator())
                .toString()));
    }

    @Test
    public void whenGetHeadSales() {
        for (final Employee headSales : this.headSales.getSubordinates()) {
            System.out.println(headSales);
        }
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Employee :[ Name : Richard, dept : Sales, salary :10000 ]")
                .append(System.lineSeparator())
                .append("Employee :[ Name : Rob, dept : Sales, salary :10000 ]")
                .append(System.lineSeparator())
                .toString()));
    }

    @Test
    public void whenGetHeadMarketing() {
        for (final Employee headSales : this.headMarketing.getSubordinates()) {
            System.out.println(headSales);
        }
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("Employee :[ Name : Laura, dept : Marketing, salary :10000 ]")
                .append(System.lineSeparator())
                .append("Employee :[ Name : Bob, dept : Marketing, salary :10000 ]")
                .append(System.lineSeparator())
                .toString()));
    }


/*

      for(
    Employee headEmployee :ceo.getSubordinates())

    {
        System.out.println(headEmployee);

        for (Employee employee : headEmployee.getSubordinates()) {
            System.out.println(employee);
        }
    }*/
}
