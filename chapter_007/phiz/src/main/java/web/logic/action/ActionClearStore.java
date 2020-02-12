package web.logic.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ActionCleanStore.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/4/2020
 */
public class ActionClearStore extends ActionAbs {
    @Override
    public final void execute(final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        this.getStore().clearStore();
        resp.sendRedirect("/index");
    }
}
