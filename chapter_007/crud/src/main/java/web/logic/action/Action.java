package web.logic.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * MenuAction.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/30/2020
 */
public interface Action {
    /**
     * Method to execute action.
     *
     * @param req  a request
     * @param resp a response
     * @throws ServletException servlet exception
     * @throws IOException      io exception
     */
    void execute(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException;
}
