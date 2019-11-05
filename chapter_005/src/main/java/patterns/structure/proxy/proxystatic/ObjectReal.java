package patterns.structure.proxy.proxystatic;

/**
 * RealObject.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/21/2019
 */
public class ObjectReal implements Interface {

    @Override
    public final void doSomeThing() {
        System.out.println("Real doSomeThing");
    }

    @Override
    public final void someThingElse(final String arg) {
        System.out.println("Real someThingElse " + arg);
    }
}
