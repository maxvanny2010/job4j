package wjet;

import java.util.Objects;

/**
 * Parameters.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 12/24/2019
 */
class Parameters {
    /**
     * field limit nano time for download a one block of the file to a buffer.
     */
    static final double LIMIT_NANO = 200000;
    /**
     * field default size.
     */
    private static final int MAX_VOLUME = 1024;
    /**
     * field url.
     */
    private final String url;
    /**
     * field volume a one block of the file to a buffer.
     */
    private final int volume;

    /**
     * Constructor.
     *
     * @param args args
     */
    Parameters(final String[] args) {
        Objects.requireNonNull(args, "must not be null");
        if (args.length == 2) {
            this.volume = Integer.parseInt(args[1]);
            this.url = args[0].trim();
        } else {
            this.volume = MAX_VOLUME;
            this.url = "https://www.youtube.com/watch?v=cVRHG6z7sN8";
        }
    }

    /**
     * Method to get.
     *
     * @return url
     */
    final String getUrl() {
        return this.url;
    }

    /**
     * Method to get.
     *
     * @return volume
     */
    final int getVolume() {
        return this.volume;
    }

    /**
     * Method to get.
     *
     * @return a name file with extension by array
     */
    final String[] getCallFileName() {
        final String[] split = this.url.split("/");
        return split[split.length - 1].split("\\.");
    }
}
