package web.logic.action;

import web.logic.action.utils.Utils;
import web.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * Empty.
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
        final List<User> all = this.getStore().findAll();
        if (all.size() == 0) {
            req.getRequestDispatcher("/start.html").forward(req, resp);
        } else {
            final String[] hat = {"id", "создан", "имя", "логин", "email",
                    "редактировать", "удалить"};
            final PrintWriter writer = new PrintWriter(
                    new OutputStreamWriter(
                            resp.getOutputStream(),
                            StandardCharsets.UTF_8), true);
            Utils.getHeaderHtml(writer);
            writer.append("<div class=\"table-top\">")
                    .append("  <div class=\"table-top-row\">")
                    .append("    <div class=\"center\">")
                    .append("<p class=\"font600\">")
                    .append("Список программистов ")
                    .append("перешедших на сторону Java.")
                    .append("</p></div></div></div>")
                    .append("<div class=\"table-top\">")
                    .append("<div class=\"table-top-row\">")
                    .flush();
            Arrays.stream(hat).forEach(
                    s -> writer.append("<div class=\"table-top-cell-color\">")
                            .append("<div class=\"center\">")
                            .append(s)
                            .append("</div></div>"));
            writer.append("</div>");
            all.forEach(user -> writer.append("<div class=\"table-top-row\">")
                    .append("<div class=\"table-top-cell\">")
                    .append("<div class=\"center\">")
                    .append(Integer.toString(user.getId()))
                    .append("</div></div>")
                    .append("<div class=\"table-top-cell\">")
                    .append("<div class=\"center\">")
                    .append(user.getCreateTime())
                    .append("</div></div>")
                    .append("<div class=\"table-top-cell\">")
                    .append("<div class=\"center\">")
                    .append("<a title=\"Просмотреть запись\" href=\"/view?id=")
                    .append(Integer.toString(user.getId()))
                    .append("\">")
                    .append(user.getName())
                    .append("</a>")
                    .append("</div></div>")
                    .append("<div class=\"table-top-cell\">")
                    .append("<div class=\"center\">")
                    .append(user.getLogin())
                    .append("</div></div>")
                    .append("<div class=\"table-top-cell\">")
                    .append("<div class=\"center\">")
                    .append(user.getEmail())
                    .append("</div></div>")
                    .append("<div class=\"table-top-cell\">")
                    .append("<div class=\"center\">")
                    .append("<a title=\"Редактировать запись\" ")
                    .append("href=\"/edit?fall=no&id=")
                    .append(Integer.toString(user.getId()))
                    .append("\">")
                    .append("<img src=\"img/edit.png\" alt=\"edit\">")
                    .append("</a></div></div>")
                    .append("<div class=\"table-top-cell\">")
                    .append("<div class=\"center\">")
                    .append("<form ")
                    .append("action=\"/delete\" ")
                    .append("enctype=\"application/x-www-form-urlencoded\" ")
                    .append("method=\"POST\"> ")
                    .append("<input name=\"id\" type=\"hidden\" value=\"")
                    .append(Integer.toString(user.getId()))
                    .append("\">")
                    .append("<input class=\"del\" type=\"submit\"")
                    .append("value=\"delete\">")
                    .append("</form>")
                    .append("</div></div></div>")
                    .flush());
            writer.append("</div>")
                    .append("<div class=\"footer\">")
                    .append("<div>")
                    .append("<a href=\"/add\">")
                    .append("<img src=\"img/name.png\" alt=\"add\"")
                    .append("title=\"добавить в список\">")
                    .append("</a></div>")
                    .append("<div>")
                    .append("<a href=\"/clear\"")
                    .append("title=\"Нажать в случае провала\">")
                    .append("<img src=\"img/clear.png\" alt=\"провал\"")
                    .append("</a>")
                    .append("</div>")
                    .append("</div>")
                    .flush();
            Utils.getFooterHtml(writer);
        }
    }
}
