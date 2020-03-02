package web.present;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * BootsServlet.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 3/1/2020
 */
public class BootsServlet extends HttpServlet {
    /**
     * field a list.
     */
    private List<User> users;

    @Override
    public final void init(final ServletConfig config)
            throws ServletException {
        super.init(config);
        this.users = new ArrayList<>();
    }

    @Override
    public final void doPost(final HttpServletRequest req,
                             final HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");
        final String state = req.getParameter("state");
        final User user = new User(email, password, state);
        this.users.add(user);
        this.doGet(req, resp);
    }

    @Override
    public final void doGet(final HttpServletRequest req,
                            final HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("users", this.users);
        req.getRequestDispatcher("WEB-INF/jsp/index.jsp")
                .forward(req, resp);
    }
    /**
     * User.
     *
     * @author Maxim Vanny
     * @version 5.0
     * @since 3/1/2020
     */
   public static class User {
        /**
         * field a email.
         */
        private final String email;
        /**
         * field a password.
         */
        private final String password;
        /**
         * field a state.
         */
        private final String state;

        /**
         * Constructor.
         *
         * @param aEmail    a email
         * @param aPassword a password
         * @param aState    a state
         */
        User(final String aEmail, final String aPassword,
             final String aState) {
            this.email = aEmail;
            this.password = aPassword;
            this.state = aState;
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
         * @return a password
         */
        public final String getPassword() {
            return this.password;
        }

        /**
         * Method to get.
         *
         * @return a state
         */
        public final String getState() {
            return this.state;
        }

        @Override
        public final String toString() {
            return new StringJoiner(", ",
                    User.class.getSimpleName() + "[", "]")
                    .add("email='" + email + "'")
                    .add("password='" + password + "'")
                    .add("state='" + state + "'")
                    .toString();
        }
    }
}
