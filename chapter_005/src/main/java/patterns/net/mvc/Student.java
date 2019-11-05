package patterns.net.mvc;

/**
 * Student.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/31/2019
 */
public class Student {
    /**
     * field id.
     */
    private String id;
    /**
     * field name.
     */
    private String name;

    /**
     * Method to getter.
     *
     * @return id
     */
    public final String getId() {
        return this.id;
    }

    /**
     * Method to setter.
     *
     * @param aId id
     */
    public final void setId(final String aId) {
        this.id = aId;
    }

    /**
     * Method to getter.
     *
     * @return name
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Method to setter.
     *
     * @param aName name
     */
    public final void setName(final String aName) {
        this.name = aName;
    }
}
