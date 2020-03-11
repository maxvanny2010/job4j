package web.present;

import web.logic.service.Logic;
import web.logic.service.LogicService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * UserDeleteServlet.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/8/2020
 */
public class UserDeleteServlet extends HttpServlet {
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
    protected final void doPost(final HttpServletRequest req,
                                final HttpServletResponse resp)
            throws ServletException, IOException {
        this.logic.runAction("delete", req, resp);
    }
}
