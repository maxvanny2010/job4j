package patterns.structure.proxy.proxyprotected.access;

import patterns.structure.proxy.proxyprotected.users.UsersAbs;

/**
 * AccessDefine.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/23/2019
 */
public class AccessDefine extends AccessAbs {
    /**
     * Constructor.
     *
     * @param aUsers users
     */
    AccessDefine(final UsersAbs aUsers) {
        super(aUsers);
    }

    @Override
    public final void access() {
        System.out.printf("Access no apply: %s\n",
                this.getUsers().getCategory());
    }
}
