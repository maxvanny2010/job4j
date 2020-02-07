package web.logic.action.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Utils.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/3/2020
 */
public final class Utils {
    /**
     * Constructor.
     */
    private Utils() {
    }

    /**
     * Method to get.
     *
     * @param writer current writer
     */
    public static void getHeaderHtml(final PrintWriter writer) {
        writer.append("<html lang=\"\">")
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
                .append("   <div class=\"table-top-cell\">")
                .append("<img src=\"img/arms.png\" alt=\"arms\">")
                .append("   </div>")
                .append("   <div class=\"table-top-cell-center\">")
                .append("               <p class=\"b\"> TOP SECRET.</p>")
                .append("               <p>Headquarters the Microsoft.</p>")
                .append("    </div>")
                .append("   </div>")
                .append("</div><hr>")
                .flush();
    }

    /**
     * Method to get.
     *
     * @param writer current writer
     */
    public static void getFooterHtml(final PrintWriter writer) {
        writer.append("</body")
                .append("</html>")
                .flush();
    }

    /**
     * Method checks the state of parameters from request.
     *
     * @param req a request
     * @return result
     */
    public static boolean isParameters(final HttpServletRequest req) {
        return req.getParameterMap()
                .values()
                .stream()
                .flatMap(Arrays::stream)
                .allMatch(v -> v.length() != 0);
    }
}
