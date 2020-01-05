package wjet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

/**
 * FileDownloadTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 12/25/2019
 */
public class FileDownloadTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void setAfter() {
        System.setOut(System.out);
    }

    @Test
    public void whenTestMain() throws Exception {
        DownloadFile.main(new String[]{"args"});
        final byte[] out = this.bos.toByteArray();
        assertTrue(out.length > 0);
    }

    @Test
    public void whenTestDownloadFile() throws Exception {
        final var baseDir = "https://github.com/mailtime2010/job4j/blob/master";
        final var path = baseDir + "/chapter_005/sqlite.db";
        final var limitByte = "500";
        final String[] a = {path, limitByte};
        final Parameters aParam = new Parameters(a);
        final Thread thread = new Thread(new Downloader(aParam));
        thread.start();
        thread.join();
        thread.interrupt();
        final byte[] out = this.bos.toByteArray();
        assertTrue(out.length > 0);
    }
}


