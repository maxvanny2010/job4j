package ua.nino.present;

import ua.nino.logic.service.Logic;
import ua.nino.logic.service.LogicService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.nino.logic.action.utils.actionutil.PresentUtil.runTask;

/**
 * ControllerServlet.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 5/11/2020
 */
public class ControllerServlet extends HttpServlet {
    /**
     * field a logic.
     */
    private final Logic logic = LogicService.getInstance();

    /**
     * Method post.
     *
     * @param req  a request
     * @param resp a response
     * @throws IOException oi exception
     */
    @Override
    protected final void doPost(final HttpServletRequest req,
                                final HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        runTask(req, resp, logic);
    }
}
