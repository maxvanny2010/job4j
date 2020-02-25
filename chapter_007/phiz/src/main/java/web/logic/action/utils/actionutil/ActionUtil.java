package web.logic.action.utils.actionutil;

import org.apache.commons.fileupload.FileItem;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
     * @return the first row a table of user store
     */
    public static List<String> firstRow() {
        return Arrays.asList("фото", "создан", "имя", "логин", "почта",
                "редактировать", "удалить");
    }

    /**
     * Method to get.
     *
     * @param item a item
     * @return a result of item type
     */
    public static boolean isType(final FileItem item) {
        final String type = item.getName().split("\\.")[1];
        return Set.of("jpg", "png", "bmp").contains(type);
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
     * Method to check size file.
     *
     * @param size a size stream
     * @return result
     */
    public static boolean is20kB(final int size) {
        final int kB = 1000;
        final int border = 20;
        return (size != 0) && (size / kB < border);
    }
}
