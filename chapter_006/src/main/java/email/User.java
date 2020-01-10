package email;

/**
 * User.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/9/2020
 */
class User {
    /**
     * field a name.
     */
    private final String name;
    /**
     * field a email.
     */
    private final String email;

    /**
     * Constructor.
     *
     * @param aName  a name
     * @param aEmail a email
     */
    User(final String aName, final String aEmail) {
        this.name = aName;
        this.email = aEmail;
    }

    /**
     * Method to get.
     *
     * @return name
     */
    final String getName() {
        return this.name;
    }

    /**
     * Method to get.
     *
     * @return email
     */
    final String getEmail() {
        return this.email;
    }

}
