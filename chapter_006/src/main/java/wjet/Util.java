package wjet;

import java.io.File;
import java.io.IOException;

/**
 * Util.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 12/24/2019
 */
final class Util {
    /**
     * Constructor.
     */
    private Util() {
    }

    /**
     * Method writes seek the name of file to tmp file.
     *
     * @param param param
     * @return tmp file
     *
     * @throws IOException exception
     */
    static File createTmpFile(final Parameters param) throws IOException {
        final var tmpDir = System.getProperty("java.io.tmpdir");
        final var path = new File(tmpDir);
        final var file = param.getCallFileName()[0];
        final var suffix = param.getCallFileName()[1];
        return File.createTempFile(file, suffix, path);
    }
}
