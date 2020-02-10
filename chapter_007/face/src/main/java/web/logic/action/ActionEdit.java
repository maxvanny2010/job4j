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
 * ActionUpdate.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/30/2020
 */
public class ActionEdit extends ActionAbs {
    @Override
    public final void execute(final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        final User user = this.getUserIdByRequest(req);
        final String id = Integer.toString(user.getId());
        final String name = user.getName();
        final String login = user.getLogin();
        final String email = user.getEmail();
        final String fall = req.getParameter("fall");
        final PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(
                        resp.getOutputStream(),
                        StandardCharsets.UTF_8), true);
        writer.append("<!DOCTYPE html>")
                .append("<html lang=\"\">")
                .append("<head>")
                .append(" <meta http-equiv=\"Content-Type\"")
                .append("            content=\"text/html; charset=UTF-8\">")
                .append(" <link rel=\"shortcut icon\"")
                .append("     href=\"img/favicon.png\" type=\"image/png\">")
                .append(" <link rel=\"stylesheet\" href=\"css/style.css\">")
                .append("                 <title>TOP SECRET</title></head>")
                .append("<hr>")
                .append("<div class=\"table-top\">")
                .append("  <div class=\"table-top-row\">")
                .append("   <div class=\"table-top-cell\">").flush();
        if (fall.equals("ok")) {
            writer.append("<img src=\"img/obama.png\" alt=\"arms\">").flush();
        } else {
            writer.append("<img src=\"img/arms.png\" alt=\"arms\">").flush();
        }
        writer.append("   </div>")
                .append("   <div class=\"table-top-cell-center\">")
                .append("               <p class=\"b\"> TOP SECRET.</p>")
                .append("               <p>Headquarters the Microsoft.</p>")
                .append("    </div>")
                .append("   </div>")
                .append("</div><hr>")
                .append("<div class=\"table-top\">")
                .append("  <div class=\"table-top-row\">")
                .append("    <div class=\"center\">")
                .append("      <p class=\"font600\">")
                .append("Редактирование данных программиста ")
                .append("перешедшего на сторону Java.")
                .append("</p>")
                .flush();
        if (fall.equals("ok")) {
            writer.append("<div class=\"center\">")
                    .append("<p class=\"font600\" style=\"color: crimson\">")
                    .append("Вы не прошли проверку безопасности.</p>")
                    .append(" </div>")
                    .append("<div class=\"center\">")
                    .append("<p class=\"font600\" style=\"color: crimson\">")
                    .append("Заполните все поля.</p>")
                    .append("</div></div>")
                    .flush();
        }
        writer.append("<div class=\"right\">")
                .append("<p class=\"b\">")
                .append("<a class=\"link\" href=\"/index\">Назад к списку</a>")
                .append("</p></div>")
                .append("</div></div></div>")
                .append("<div class=\"table-top\">")
                .append("<div class=\"table-top-row\">")
                .append("<form method=\"POST\" action=\"/edit\"")
                .append("enctype=\"application/x-www-form-urlencoded\">")
                .append("<input type=\"hidden\"")
                .append("name=\"action\" value=\"edited\">")
                .append("<input type=\"hidden\" name=\"id\" value=")
                .append(id)
                .append(">")
                .append("<div class=\"input-container\">")
                .append("<i class=\"icon\"><img alt=\"name\"")
                .append("src=\"img/name.png\"></i>")
                .append("<label>")
                .append("<input class=\"input-field\" name=\"name\"")
                .append("placeholder=\"Name\" type=\"text\" value=\"")
                .append(name)
                .append("\"></label></div>")
                .append("<div class=\"input-container\">")
                .append("<i class=\"icon\"><img alt=\"login\"")
                .append("src=\"img/login.png\"></i>")
                .append("<label>")
                .append("<input class=\"input-field\" name=\"login\"")
                .append("placeholder=\"Login\" type=\"text\" value=\"")
                .append(login)
                .append("\"><label></div>")
                .append("<div class=\"input-container\">")
                .append("<i class=\"icon\"><img alt=\"email\"")
                .append("src=\"img/email.png\"></i>")
                .append("<label>")
                .append("<input class=\"input-field\" name=\"email\"")
                .append("placeholder=\"Email\" type=\"text\" value=\"")
                .append(email)
                .append("\"><label></div>")
                .append("<div class=\"input-container\">")
                .append("<i class=\"icon\"></i>")
                .append(" <button class=\"btn\" type=\"submit\">")
                .append("<b>Сохранить</b></button>")
                .append("</form>")
                .append("</div>")
                .flush();
        Utils.getFooterHtml(writer);
    }
}
