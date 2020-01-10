package email;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Email.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/9/2020
 */
class Email {
    /**
     * field a subject.
     */
    private final String subject;
    /**
     * field a body.
     */
    private final String body;
    /**
     * field a email.
     */
    private final String email;

    /**
     * Constructor.
     *
     * @param aSubject a subject
     * @param aBody    a body
     * @param aEmail   a email
     */
    Email(final String aSubject, final String aBody, final String aEmail) {
        this.subject = aSubject;
        this.body = aBody;
        this.email = aEmail;
    }

    /**
     * Method to get.
     *
     * @return a subject
     */
    final String getSubject() {
        return this.subject;
    }

    /**
     * Method to get.
     *
     * @return a body
     */
    final String getBody() {
        return this.body;
    }

    /**
     * Method to get.
     *
     * @return a email
     */
    final String getEmail() {
        return this.email;
    }

    @Override
    public final String toString() {
        return new StringJoiner("\n")
                .add("\nsubject:" + subject)
                .add("body:" + body)
                .add("email:" + email)
                .toString();
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Email)) {
            return false;
        }
        final Email email1 = (Email) o;
        return Objects.equals(getSubject(), email1.getSubject())
                && Objects.equals(getBody(), email1.getBody())
                && getEmail().equals(email1.getEmail());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getSubject(), getBody(), getEmail());
    }
}
