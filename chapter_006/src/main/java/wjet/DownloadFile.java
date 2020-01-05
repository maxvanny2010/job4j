package wjet;

/**
 * DownloadFile.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 12/26/2019
 */
final class DownloadFile {
    /**
     * Constructor.
     */
    private DownloadFile() {
    }

    /**
     * Method the point to enter in program.
     *
     * @param args args
     * @throws InterruptedException InterruptedException
     */
    public static void main(final String[] args) throws InterruptedException {
        final var baseDir = "https://github.com/mailtime2010/job4j/blob/master";
        final var path = baseDir + "/chapter_005/sqlite.db";
        final var limitByte = "500";
        final String[] a = {path, limitByte};
        final Parameters aParam = new Parameters(a);
        final Thread thread = new Thread(new Downloader(aParam));
        thread.start();
        thread.join();
        thread.interrupt();
    }
}
