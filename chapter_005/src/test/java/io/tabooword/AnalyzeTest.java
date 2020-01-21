package io.tabooword;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AnalyzeTest {
    private static final File SOURCE = new File("config/server.log");
    private static final File TARGET = new File("config/unavailable.log");
    private final Analyze analyze = new Analyze();

    @Before
    public void before() {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(SOURCE))) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Files.createFile(Path.of(String.valueOf(TARGET)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void setAfter() {
        try {
            Files.deleteIfExists(Path.of(String.valueOf(SOURCE)));
            Files.deleteIfExists(Path.of(String.valueOf(TARGET)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenUnavailableOk() throws IOException {
        final String source = SOURCE.getAbsolutePath();
        final String target = TARGET.getAbsolutePath();
        this.analyze.unavailable(source, target);
        final String result = Files.readString(Paths.get(target));
        final String expected = new StringBuilder()
                .append("\n200 10:56:01; 500 10:57:01; 400 10:58:01; \n")
                .append("200 10:59:01; 500 11:01:02; \n")
                .append("200 11:02:02; ")
                .toString();
        Assert.assertEquals(expected, result);
    }

    @Test(expected = FileNotFoundException.class)
    public void whenUnavailableFallFilesSourceAndTarget() throws IOException {
        this.analyze.unavailable("SOURCES", "TARGETS");
    }
}
