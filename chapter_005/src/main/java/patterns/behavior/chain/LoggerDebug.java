package patterns.behavior.chain;

/**
 * LoggerDebug.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/13/2019
 */
public class LoggerDebug extends LoggerAbstract {
    /**
     * Constructor.
     */
    LoggerDebug() {
        this.setLevel(LoggerAbstract.DEBUG);
    }

    @Override
    protected final void write(final String message) {
        System.out.println("standard::DEBUG::" + message);
    }
}
