package patterns.behavior.observer;

/**
 * ObserverConsole.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/28/2019
 */
public class ObserverConsole implements Observer {
    @Override
    public final void handleEvent(final int temp, final int press) {
        System.out.printf("Temperature: %s  Pressure: %s\\n", temp, press);
    }
}
