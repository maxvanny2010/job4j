package patterns.net.mvc;

/**
 * StudentView.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/31/2019
 */
class View {
    /**
     * Method print.
     *
     * @param name name
     * @param id   id
     */
    final void printStudentDetails(final String name, final String id) {
        System.out.println("Student: ");
        System.out.println("Name: " + name);
        System.out.println("Id: " + id);
    }
}
