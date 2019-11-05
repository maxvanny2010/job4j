package patterns.behavior.chain;

/**
 * LoggerError.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/13/2019
 */
public class LoggerError extends LoggerAbstract {
    /**
     * Constructor.
     */
    LoggerError() {
        this.setLevel(LoggerAbstract.ERROR);
    }

    @Override
    protected final void write(final String message) {
        System.out.println("standard::ERROR::" + message);
    }
}
