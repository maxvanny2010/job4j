package wjet;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Worker.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 12/24/2019
 */
class Worker {
    /**
     * field param.
     */
    private final Parameters param;
    /**
     * field BufferedInputStream.
     */
    private BufferedInputStream in;
    /**
     * field FileOutputStream.
     */
    private FileOutputStream out;
    /**
     * field sum bytes.
     */
    private int sum;

    /**
     * Constructor.
     *
     * @param aParam param
     */
    Worker(final Parameters aParam) {
        this.param = aParam;
    }

    /**
     * Method download file.
     *
     * @throws Exception exception
     */
    final synchronized void downloadFile() throws Exception {
        final var url = new URL(this.param.getUrl());
        try {
            if (!Thread.currentThread().isInterrupted()) {
                this.in = new BufferedInputStream(url.openStream());
                this.out = new FileOutputStream(Util.createTmpFile(this.param));
                this.loadBuffer();
                System.out.printf("result: %db", this.sum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.in.close();
            this.out.close();
        }
    }

    /**
     * Method load data to buffer.
     *
     * @throws IOException io exception
     */
    private synchronized void loadBuffer() throws IOException {
        final int size = 1024;
        final byte[] buffer = new byte[size];
        final var volume = this.param.getVolume();
        while (true) {
            final double start = System.nanoTime();
            int bytes = this.in.read(buffer, 0, volume);
            if (bytes == -1) {
                break;
            }
            this.out.write(buffer, 0, bytes);
            final double end = System.nanoTime();
            this.checkOutOfTimeLimit(start, end, bytes);
            this.sum += bytes;
        }
    }

    /**
     * Method to check time out of border during to load a data to buffer.
     *
     * @param start start time start control buffer
     * @param end   end time start control buffer
     * @param bytes bytes
     */
    private synchronized void checkOutOfTimeLimit(final double start,
                                                  final double end,
                                                  final int bytes) {
        final double time = end - start;
        final double timeout = Parameters.LIMIT_NANO - time;
        if (time > Parameters.LIMIT_NANO) {
            try {
                TimeUnit.SECONDS.sleep((long) timeout);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.printf("Speed: %.5f kb/n\n", bytes / time);
    }
}

