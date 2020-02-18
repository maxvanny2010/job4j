package web.logic.action;

import web.logic.action.utils.actionutil.ActionUtil;
import web.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * ActionEmpty.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/30/2020
 */
public class ActionIndex extends ActionAbs {
    @Override
    public final void execute(final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws ServletException, IOException {
        final List<User> store = this.getStore().findAll();
        if (store.size() == 0) {
            final String path = "WEB-INF/jsp/empty.jsp";
            final RequestDispatcher dispatcher = req.getRequestDispatcher(path);
            dispatcher.forward(req, resp);
        } else {
            req.setAttribute("store", store);
            req.setAttribute("hats", ActionUtil.firstRow());
            final String path = "WEB-INF/jsp/index.jsp";
            final RequestDispatcher dispatcher = req.getRequestDispatcher(path);
            dispatcher.forward(req, resp);
        }
    }
}
