package ua.todo.view.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.util.HashMap;

/**
 * UtilAjax.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 3/21/2020
 */
public final class Util {
    /**
     * Constructor.
     */
    private Util() {
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
     * @param send a object mapper
     * @param req  a request
     * @return data by ajax
     *
     * @throws JsonProcessingException JsonProcessingException
     */
    public static HashMap<String, String> getJSON(final ObjectMapper send,
                                                  final HttpServletRequest req)
            throws JsonProcessingException {
        final String json = getStream(req);
        final TypeReference<HashMap<String, String>> map
                = new TypeReference<>() {
        };
        return send.readValue(json, map);
    }
}
