package ua.autos.logic.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * ActionBase.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/30/2020
 */
public class ActionBase extends ActionAbs {

    @Override
    public final void execute(final HashMap<String, String> json,
                              final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("WEB-INF/html/auto.html")
                .forward(req, resp);
    }
}
