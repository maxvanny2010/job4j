package email;

import java.util.HashMap;
import java.util.Map;

/**
 * Receiver.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/9/2020
 */
final class Receiver {
    /**
     * field a map.
     */
    private static final Map<String, Email> MAILBOX = new HashMap<>();

    /**
     * Constructor.
     */
    private Receiver() {
    }

    /**
     * Method to get.
     *
     * @return a map
     */
    public static Map<String, Email> getMap() {
        return MAILBOX;
    }

    /**
     * Method to add email to map.
     *
     * @param email a email
     */
    public static void addEmail(final Email email) {
        MAILBOX.putIfAbsent(email.getEmail(), email);
    }
}
