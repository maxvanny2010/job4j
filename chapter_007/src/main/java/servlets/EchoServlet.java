package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

/**
 * EchoServlet.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/24/2020
 */
public class EchoServlet extends HttpServlet {
    /**
     * field a logger.
     */
    @SuppressWarnings("unused")
    private static final Logger LOGGER = Logger.getLogger(
            EchoServlet.class.getName());
    /**
     * field a list.
     */
    private final List<String> users = new CopyOnWriteArrayList<>();

    @Override
    protected final void doGet(final HttpServletRequest req,
                               final HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        final PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("hello world, ").append(this.users.toString());
        writer.flush();
    }

    @Override
    protected final void doPost(final HttpServletRequest req,
                                final HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/html");
        final String login = req.getParameter("login");
        this.users.add(login);
        doGet(req, resp);
    }
}
