package web.logic.action;

import web.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * ActionLoad.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/15/2020
 */
public class ActionLoad extends ActionAbs {
    @Override
    public final void execute(final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        final String id = req.getParameter("id");
        resp.setContentType("image/png");
        resp.setHeader("Content-Disposition",
                "attachment; filename=\"" + id + ".png\"");
        final User user = this.getStore().findById(Integer.parseInt(id));
        final byte[] image = user.getImage();
        try (ByteArrayInputStream bis = new ByteArrayInputStream(image)) {
            resp.getOutputStream().write(bis.readAllBytes());
        }
    }
}
