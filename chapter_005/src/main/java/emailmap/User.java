package emailmap;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

/**
 * User.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 9/28/2019
 */
public class User {
    /**
     * field email.
     */
    private Set<String> emails = new HashSet<>();

    /**
     * Method to set a Set of mails.
     * @param email a email
     */
    public final void setEmail(final String email) {
        this.emails.add(email);
    }

    /**
     * Method to get a Set of mails.
     * @return the Set
     */
    public final Set<String> getEmails() {
        return this.emails;
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                User.class.getSimpleName() + "[", "]")
                .add("emails=" + emails)
                .add("\\n")
                .toString();
    }
}
