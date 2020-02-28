package web.present;

import web.logic.service.Logic;
import web.logic.service.LogicService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * UserLoginServlet.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/20/2020
 */
public class UserLoginGateServlet extends HttpServlet {
    /**
     * field a logic.
     */
    private Logic logic;

    @Override
    public final void init() {
        this.logic = LogicService.getInstance();
    }

    @Override
    public final void doPost(final HttpServletRequest req,
                             final HttpServletResponse resp)
            throws ServletException, IOException {
        this.logic.runAction("login", req, resp);
    }

    @Override
    public final void doGet(final HttpServletRequest req,
                            final HttpServletResponse resp)
            throws ServletException, IOException {
        this.logic.runAction("gate", req, resp);
    }
}
