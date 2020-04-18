package ua.autos.logic.action.utils.actionutil;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ActionUtil.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/3/2020
 */
public final class ActionUtil {
    /**
     * Constructor.
     */
    private ActionUtil() {
    }

    /**
     * Method to get.
     *
     * @param folder a folder
     * @param file   a file
     * @param req    a request
     * @return a path for default image
     */
    public static String getPath(final String folder,
                                 final String file,
                                 final HttpServletRequest req) {
        final String path = req.getServletContext().getRealPath(folder);
        return new StringBuilder()
                .append(File.separator)
                .append(path)
                .append(File.separator)
                .append(file)
                .toString();
    }

    /**
     * Method to get.
     *
     * @param path a path
     * @return default image by byte array
     */
    public static byte[] getBytes(final String path) {
        try (FileInputStream fis = new FileInputStream(path)) {
            return fis.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    /**
     * Method to register a user.
     *
     * @param <T>    type
     * @param resp   a response
     * @param object a object
     * @throws IOException io exception
     */
    public static <T> void setOut(final HttpServletResponse resp,
                                  final T object)
            throws IOException {
        resp.setContentType("application/json; charset=UTF-8");
        final ObjectMapper mapper = new ObjectMapper();
        final String outs = mapper.writeValueAsString(object);
        final PrintWriter out = resp.getWriter();
        out.print(outs);
        out.flush();
        out.close();
    }
}
