package ua.autos.present;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * PCabinetServlet.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 5/15/2020
 */
public class PCabinetServlet extends HttpServlet {

    /**
     * Method get.
     *
     * @param req  a request
     * @param resp a response
     * @throws IOException oi exception
     */
    @Override
    protected final void doGet(final HttpServletRequest req,
                               final HttpServletResponse resp)
            throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("WEB-INF/html/cabinet.html")
                .forward(req, resp);
    }
}
