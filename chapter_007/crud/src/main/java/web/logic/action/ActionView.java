package web.logic.action;

import web.logic.action.utils.Utils;
import web.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * ActionView.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/31/2020
 */
public class ActionView extends ActionAbs {
    @Override
    public final void execute(final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        final User user = this.getUserIdByRequest(req);
        final PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(
                        resp.getOutputStream(),
                        StandardCharsets.UTF_8), true);
        Utils.getHeaderHtml(writer);
        writer.append("<div class=\"table-top\">")
                .append("<div class=\"table-top-row\">")
                .append("<div class=\"center\">")
                .append("<p class=\"font600\">")
                .append("Данные ")
                .append(user.getName())
                .append(" перешедшего на сторону Java.")
                .append("</p></div>")
                .append("<div class=\"right\">")
                .append("<p class=\"b\"><a href =\"/index\">")
                .append("Назад к списку")
                .append("</a></p></div>")
                .append("<div class=\"table-top-row\">")
                .append(user.getName())
                .append("</div>")
                .append("<div class=\"table-top-row\">")
                .append(user.getLogin())
                .append("</div>")
                .append("<div class=\"table-top-row\">")
                .append(user.getEmail())
                .append("</div>")
                .append("<div class=\"right\">")
                .append("<p class=\"b\">")
                .append("<a href =\"/index?action=delete&id=")
                .append(Integer.toString(user.getId()))
                .append("\">").append(" Удалить ")
                .append(user.getName())
                .append("</a></p>")
                .append("</div>")
                .append("<p align =\"right\">")
                .append("<img src =\"img/arms_2.png\" ")
                .append("alt=\"the finger of GOD\" ")
                .append("title=\"the finger of GOD\">")
                .append("</div></div>")
                .append("</body>")
                .append("</html>")
                .flush();
    }
}
