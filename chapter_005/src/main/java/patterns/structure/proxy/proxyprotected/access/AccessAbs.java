package patterns.structure.proxy.proxyprotected.access;


import patterns.structure.proxy.proxyprotected.users.UsersAbs;

/**
 * AccessAbs.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/23/2019
 */
public abstract class AccessAbs implements Access {
    /**
     * field users.
     */
    private final UsersAbs users;

    /**
     * Constructor.
     *
     * @param aUsers users
     */
    AccessAbs(final UsersAbs aUsers) {
        this.users = aUsers;
    }

    /**
     * Getter users.
     *
     * @return the user
     */
    final UsersAbs getUsers() {
        return this.users;
    }

    @SuppressWarnings("unused")
    @Override
    public abstract void access();
}
