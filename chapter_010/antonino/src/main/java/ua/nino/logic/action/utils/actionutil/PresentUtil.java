package ua.nino.logic.action.utils.actionutil;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ua.nino.logic.service.Logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.HashMap;

/**
 * PresentUtil.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 3/21/2020
 */
public final class PresentUtil {
    /**
     * Constructor.
     */
    private PresentUtil() {
    }

    /**
     * Method to get.
     *
     * @param req a request
     * @return a ajax by string
     */
    private static String getStream(final HttpServletRequest req) {
        final StringBuilder sb = new StringBuilder();
        String line;
        try {
            final BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * Method to get.
     *
     * @param req a request
     * @return data by ajax
     *
     * @throws Exception a exception
     */
    public static HashMap<String, String> getJSON(final HttpServletRequest req)
            throws Exception {
        req.setCharacterEncoding("UTF-8");
        String json = getStream(req);
        final ObjectMapper mapper = new ObjectMapper();
        final TypeReference<HashMap<String, String>> map
                = new TypeReference<>() {
        };
        if (json.isEmpty()) {
            json = "{\"action\":\"base\"}";
        }
        return mapper.readValue(json, map);
    }

    /**
     * Method to run tasks.
     *
     * @param req   a request
     * @param resp  a response
     * @param logic a logic
     */
    public static void runTask(final HttpServletRequest req,
                               final HttpServletResponse resp,
                               final Logic logic) {
        try {
            final HashMap<String, String> json = getJSON(req);
            final String action = json.get("action");
            logic.runAction(action, json, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
