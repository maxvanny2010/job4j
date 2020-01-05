package wjet;

/**
 * Downloader.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 12/24/2019
 */
class Downloader implements Runnable {
    /**
     * field param.
     */
    private final Parameters param;

    /**
     * Constructor.
     *
     * @param aParam parameter
     */
    Downloader(final Parameters aParam) {
        this.param = aParam;
    }


    @Override
    public final void run() {
        final Worker worker = new Worker(this.param);
        try {
            worker.downloadFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
