package patterns.behavior.chain;

/**
 * LoggerInfo.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/13/2019
 */
public class LoggerInfo extends LoggerAbstract {
    /**
     * Constructor.
     */
    LoggerInfo() {
        this.setLevel(LoggerAbstract.INFO);
    }

    @Override
    protected final void write(final String message) {
        System.out.println("standard::INFO::" + message);
    }
}
