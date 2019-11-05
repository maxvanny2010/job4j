package patterns.structure.proxy.proxystatic;

/**
 * SimpleProxy.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/21/2019
 */
public class ObjectProxy implements Interface {
    /**
     * field proxied.
     */
    private final Interface proxied;

    /**
     * Constructor.
     *
     * @param aProxied proxied
     */
    ObjectProxy(final Interface aProxied) {
        this.proxied = aProxied;
    }

    @Override
    public final void doSomeThing() {
        System.out.println("Proxy doSomething");
        this.proxied.doSomeThing();
    }

    @Override
    public final void someThingElse(final String arg) {
        System.out.println("Proxy doSomething " + arg);
        this.proxied.someThingElse(arg);
    }
}
