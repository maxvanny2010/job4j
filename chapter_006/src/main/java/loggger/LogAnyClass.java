package loggger;

import java.util.List;
import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Logger.
 *
 * @author Mailtime
 * @version 5.0
 * @since 1/23/2020
 */
final class LogAnyClass {
    /**
     * field a logger.
     */
    private static final Logger LOGGER = Logger.getLogger(
            LogAnyClass.class.getName());

    /**
     * Constructor.
     */
    private LogAnyClass() {
    }

    /**
     * Method to get.
     *
     * @return a logger level
     */
    protected static Level getLoggerLevel() {
        return LOGGER.getLevel();
    }

    /**
     * Method to set.
     *
     * @param myLevel a level of logger
     **/
    protected static void setLoggerLevel(final Level myLevel) {
        LOGGER.setLevel(myLevel);
        LOGGER.setUseParentHandlers(false);
        final Handler reg = new ConsoleHandler();
        LOGGER.addHandler(reg);
        reg.setLevel(myLevel);
    }

    /**
     * Method to enter a program.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        final Random random = new Random();
        final List<Level> list = List.of(
                Level.FINEST, Level.WARNING, Level.INFO, Level.OFF);

        setLoggerLevel(Level.INFO);
        while (getLoggerLevel() != Level.OFF) {
            final int index = random.nextInt(4);
            setLoggerLevel(list.get(index));
            LOGGER.log(getLoggerLevel(), "processing {0}  entries in loop",
                    getLoggerLevel());

        }
    }


}
