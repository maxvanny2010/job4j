package ua.nino.present;

import ua.nino.logic.service.Logic;
import ua.nino.logic.service.LogicService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * UserServlet.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/29/2020
 */
public class AutoServlet extends HttpServlet {
    /**
     * field a logic.
     */
    private final Logic logic = LogicService.getInstance();


    /**
     * Method get.
     *
     * @param req  a request
     * @param resp a response
     */
    @Override
    protected final void doGet(final HttpServletRequest req,
                               final HttpServletResponse resp) {
        try {
            this.logic.runAction("base", null, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
