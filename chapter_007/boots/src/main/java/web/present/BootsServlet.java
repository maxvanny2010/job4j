package web.present;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.StringJoiner;

/**
 * BootsServlet.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 3/1/2020
 */
public class BootsServlet extends HttpServlet {

    @Override
    public final void doPost(final HttpServletRequest req,
                             final HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
    }

    @Override
    public final void doGet(final HttpServletRequest req,
                            final HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/ajax.html")
                .forward(req, resp);
    }

    /**
     * User.
     *
     * @author Maxim Vanny
     * @version 5.0
     * @since 3/1/2020
     */
    @SuppressWarnings("unused")
    public static class User {
        /**
         * field a email.
         */
        private final String name;
        /**
         * field a email.
         */
        private final String email;
        /**
         * field a email.
         */
        private final String country;
        /**
         * field a email.
         */
        private final String city;
        /**
         * field a state.
         */
        private final String gender;
        /**
         * field a password.
         */
        private final String password;

        /**
         * Constructor.
         *
         * @param aName     a name
         * @param aEmail    a email
         * @param aCountry  a country
         * @param aCity     a city
         * @param aPassword a password
         * @param aGender   a state
         */
        User(final String aName, final String aEmail,
             final String aCountry, final String aCity,
             final String aGender, final String aPassword) {
            this.name = aName;
            this.email = aEmail;
            this.country = aCountry;
            this.city = aCity;
            this.gender = aGender;
            this.password = aPassword;
        }

        /**
         * Constructor.
         *
         * @param aName   a name
         * @param aGender a gender
         */
        public User(final String aName, final String aGender) {
            this.name = aName;
            this.gender = aGender;
            this.email = null;
            this.country = null;
            this.city = null;
            this.password = null;

        }

        /**
         * Method to get.
         *
         * @return a name
         */
        public final String getName() {
            return this.name;
        }

        /**
         * Method to get.
         *
         * @return a email
         */
        public final String getEmail() {
            return this.email;
        }

        /**
         * Method to get.
         *
         * @return a country
         */
        public final String getCountry() {
            return this.country;
        }

        /**
         * Method to get.
         *
         * @return a city
         */
        public final String getCity() {
            return this.city;
        }

        /**
         * Method to get.
         *
         * @return a state
         */
        public final String getGender() {
            return this.gender;
        }

        /**
         * Method to get.
         *
         * @return a password
         */
        public final String getPassword() {
            return this.password;
        }

        @Override
        public final String toString() {
            return new StringJoiner(", ",
                    User.class.getSimpleName() + "[", "]")
                    .add("name='" + name + "'")
                    .add("email='" + email + "'")
                    .add("country='" + country + "'")
                    .add("city='" + city + "'")
                    .add("gender='" + gender + "'")
                    .add("password='" + password + "'")
                    .toString();
        }
    }

}
