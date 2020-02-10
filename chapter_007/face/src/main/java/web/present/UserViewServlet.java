package web.present;

import web.logic.Logic;
import web.logic.LogicService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * UserViewServlet.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/8/2020
 */
public class UserViewServlet extends HttpServlet {
    /**
     * field a logic.
     */
    private Logic logic;

    @Override
    public final void init(final ServletConfig config) throws ServletException {
        super.init(config);
        this.logic = LogicService.getInstance();
    }

    /**
     * Method post.
     *
     * @param req  a request
     * @param resp a response
     */
    protected final void doPost(final HttpServletRequest req,
                                final HttpServletResponse resp) {
    }

    /**
     * Method post.
     *
     * @param req  a request
     * @param resp a response
     * @throws ServletException servlet exception
     * @throws IOException      io exception
     */
    protected final void doGet(final HttpServletRequest req,
                               final HttpServletResponse resp)
            throws ServletException, IOException {
        this.logic.runAction("view", req, resp);
    }
}
