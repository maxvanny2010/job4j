package accident;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Main.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/14/2020
 */
public final class Main {
    /**
     * Constructor.
     */
    private Main() {
    }

    /**
     * Method to point in program.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String pwd = encoder.encode("secret");
        System.out.println(pwd);
    }
}
