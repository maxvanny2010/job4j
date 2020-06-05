package accident.util;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Util.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/6/2020
 */
public final class Util {
    /**
     * field a atom.
     */
    public static final AtomicInteger ATOM = new AtomicInteger();

    /**
     * Constructor.
     */
    private Util() {
    }

    /**
     * Method to get.
     *
     * @return generator a id
     */
    public static int getATOM() {
        return ATOM.getAndIncrement();
    }

    /**
     * Method to get.
     *
     * @return the header of table
     */
    public static List<String> getHat() {
        return Arrays.asList(
                "id", "имя", "номер", "адрес", "описание", "фото", "fa");
    }

    /**
     * Method to get.
     *
     * @param request a request
     * @return default image by byte array
     */
    @SuppressWarnings("unused")
    public static byte[] getBytes(final HttpServletRequest request) {
        final String folder = request.getServletContext().getRealPath("/img");
        final String path = folder + File.separator + "default.png";
        try {
            return Files.readAllBytes(Path.of(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
