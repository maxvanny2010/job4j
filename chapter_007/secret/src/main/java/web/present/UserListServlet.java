package web.present;

import web.logic.service.Logic;
import web.logic.service.LogicService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * UserServlet.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/29/2020
 */
public class UserListServlet extends HttpServlet {
    /**
     * field a logic.
     */
    private Logic logic;

    @Override
    public final void init() {
        this.logic = LogicService.getInstance();
    }

    /**
     * Method post.
     *
     * @param req  a request
     * @param resp a response
     * @throws ServletException servlet exception
     * @throws IOException      oi exception
     */
    protected final void doGet(final HttpServletRequest req,
                               final HttpServletResponse resp)
            throws ServletException, IOException {
        this.logic.runAction(null, req, resp);
    }
}
