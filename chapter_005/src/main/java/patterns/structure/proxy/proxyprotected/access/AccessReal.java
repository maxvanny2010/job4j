package patterns.structure.proxy.proxyprotected.access;

import patterns.structure.proxy.proxyprotected.users.UsersAbs;

/**
 * AccessReal.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/23/2019
 */
public class AccessReal extends AccessAbs {
    /**
     * Constructor.
     *
     * @param aUsers users
     */
    AccessReal(final UsersAbs aUsers) {
        super(aUsers);
    }

    @Override
    public final void access() {
        System.out.printf("Access to apply: %s\n",
                this.getUsers().getCategory());
    }
}
