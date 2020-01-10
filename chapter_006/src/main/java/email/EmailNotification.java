package email;


import javax.annotation.Nonnull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * EmailNotification.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/9/2020
 */
class EmailNotification {
    /**
     * field a poll.
     */
    private final ExecutorService poll;

    /**
     * Constructor.
     */
    EmailNotification() {
        final int size = Runtime.getRuntime().availableProcessors();
        this.poll = Executors.newFixedThreadPool(size);
    }

    /**
     * Method to get.
     *
     * @return a poll
     */
    public final ExecutorService getPoll() {
        return this.poll;
    }

    /**
     * Method to close.
     */
    final void close() {
        this.poll.shutdown();
        sleepIfTerminated();
    }

    /**
     * Method to set to sleep if threads of pool don't terminated.
     */
    private void sleepIfTerminated() {
        while (!this.poll.isTerminated()) {
            try {
                final int millis = 100;
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method to sent email to user.
     *
     * @param user a user receiver
     **/
    final void emailTo(@Nonnull final User user) {
        this.poll.submit(() -> {
            final Email email = new Email(sub(user), body(user), email(user));
            this.send(email.getSubject(), email.getBody(), email.getEmail());
        });
    }

    /**
     * Method to sent email.
     *
     * @param sub   a subject
     * @param body  a body
     * @param email a email
     */
    private void send(final String sub, final String body, final String email) {
        Receiver.addEmail(new Email(sub, body, email));
    }

    /**
     * Method to get.
     *
     * @param user a user
     * @return the body by user
     */
    private String body(@Nonnull final User user) {
        return new StringBuilder()
                .append("Event for ")
                .append(user.getName())
                .toString();
    }

    /**
     * Method to get.
     *
     * @param user a user
     * @return the subject by user
     */
    private String sub(@Nonnull final User user) {
        return new StringBuilder()
                .append("Notification ")
                .append(user.getName())
                .append(",")
                .append(" email ")
                .append(user.getEmail())
                .toString();
    }

    /**
     * Method to get.
     *
     * @param user a user
     * @return the email by user
     */
    private String email(@Nonnull final User user) {
        return new StringBuilder()
                .append(user.getEmail())
                .toString();
    }
}
