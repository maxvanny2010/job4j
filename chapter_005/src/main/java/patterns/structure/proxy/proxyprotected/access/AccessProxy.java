package patterns.structure.proxy.proxyprotected.access;

import patterns.structure.proxy.proxyprotected.users.UsersAbs;

/**
 * UserProxy.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/23/2019
 */
public class AccessProxy extends AccessAbs {
    /**
     * Constructor.
     *
     * @param aUser user
     */
    public AccessProxy(final UsersAbs aUser) {
        super(aUser);
    }

    @Override
    public final void access() {
        new AccessStore().select(super.getUsers().getCategory()).access();
    }
}
