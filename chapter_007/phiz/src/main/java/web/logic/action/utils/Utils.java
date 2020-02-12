package web.logic.action.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

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

    /**
     * Method to get.
     *
     * @return the first row a table of user store
     */
    public static List<String> firstRow() {
        return Arrays.asList("id", "создан", "имя", "логин", "email",
                "редактировать", "удалить");
    }
}
