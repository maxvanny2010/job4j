package patterns.behavior.chain;

/**
 * LoggerAbstract.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/13/2019
 */
public abstract class LoggerAbstract {
    /**
     * field INFO.
     */
    static final int INFO = 1;
    /**
     * field DEBUG.
     */
    static final int DEBUG = 2;
    /**
     * field ERROR.
     */
    static final int ERROR = 3;

    /**
     * field level.
     */
    private int level;
    /**
     * field next logger.
     */
    private LoggerAbstract nextLogger;

    /**
     * Setter a level logger.
     *
     * @param aLevel the level of logger
     */
    final void setLevel(final int aLevel) {
        this.level = aLevel;
    }

    /**
     * Method to set next logger.
     *
     * @param aNextLogger the next logger
     */
    final void setNextLogger(final LoggerAbstract aNextLogger) {
        this.nextLogger = aNextLogger;
    }

    /**
     * Method to print message by level logger.
     *
     * @param aLevel  level
     * @param message message
     */
    final void logMessage(final int aLevel, final String message) {
        if (this.level <= aLevel) {
            this.write(message);
        }
        if (this.nextLogger != null) {
            this.nextLogger.logMessage(aLevel, message);
        }
    }

    /**
     * Method to print message.
     *
     * @param message the message
     */
    protected abstract void write(String message);
}
