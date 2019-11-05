package patterns.structure.proxy.proxystatic;

/**
 * SimpleProxyDemo.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/21/2019
 */
final class SimpleProxy {
    /**
     * Constructor.
     */
    private SimpleProxy() {
    }

    /**
     * Method consumer.
     *
     * @param iFace interface
     */
    static void consumer(final Interface iFace) {
        iFace.doSomeThing();
        iFace.someThingElse("iFace");
    }
}
