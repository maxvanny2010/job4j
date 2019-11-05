package patterns.structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Employee.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/25/2019
 */
public class Employee {
    /**
     * field the name.
     */
    private final String name;
    /**
     * field the department.
     */
    private final String dept;
    /**
     * field the salary.
     */
    private final int salary;
    /**
     * field the list.
     */
    private final List<Employee> subordinates;

    /**
     * Constructor.
     *
     * @param aName   name
     * @param aDept   department
     * @param aSalary salary
     */
    Employee(final String aName, final String aDept, final int aSalary) {
        this.name = aName;
        this.dept = aDept;
        this.salary = aSalary;
        this.subordinates = new ArrayList<>();
    }

    /**
     * Method to add.
     *
     * @param e a employee
     */
    final void add(final Employee e) {
        this.subordinates.add(e);
    }

    /**
     * Method to remove.
     *
     * @param e a employee
     */
    @SuppressWarnings("unused")
    final void remove(final Employee e) {
        this.subordinates.remove(e);
    }

    /**
     * Method to get the list of employee.
     *
     * @return the list
     */
    final List<Employee> getSubordinates() {
        return this.subordinates;
    }

    @Override
    public final String toString() {
        return ("Employee :[ Name : "
                + this.name
                + ", dept : "
                + this.dept
                + ", salary :"
                + this.salary + " ]");
    }
}
