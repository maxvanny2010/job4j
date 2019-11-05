package patterns.behavior.chain;

/**
 * LoggerMain.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/13/2019
 */
final class LoggerMain {
    /**
     * Constructor.
     */
    private LoggerMain() {
    }

    /**
     * Method to set the chain loggers.
     *
     * @return the high level logger.
     */
    static LoggerAbstract baseChain() {
        final LoggerAbstract error = new LoggerError();
        final LoggerAbstract debug = new LoggerDebug();
        final LoggerAbstract info = new LoggerInfo();
        error.setNextLogger(debug);
        debug.setNextLogger(info);
        return error;
    }
}
