package patterns.structure.proxy.proxyprotected.users;

/**
 * UsersAbs.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/23/2019
 */
public abstract class UsersAbs {
    /**
     * field category.
     */
    private final String category;

    /**
     * Constructor.
     *
     * @param aCategory category
     */
    UsersAbs(final String aCategory) {
        this.category = aCategory;
    }

    /**
     * Getter category.
     *
     * @return the category
     */
    public final String getCategory() {
        return this.category;
    }

}
