package io.tabooword;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Analyze.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/6/2019
 */

public class Analyze {
    /**
     * Method unavailable.
     *
     * @param source source file
     * @param goal   goal file
     * @throws IOException           io exception
     * @throws FileNotFoundException no file exception
     */
    public final void unavailable(final String source, final String goal)
            throws IOException {
        if (!Files.exists(Path.of(source)) || !Files.exists(Path.of(goal))) {
            throw new FileNotFoundException();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(goal))) {
            var line = "";
            var base = "";
            String[] result;
            final int bound = 3;
            while ((line = reader.readLine()) != null) {
                result = line.split(" ");
                base = result[0] + " " + result[1].trim() + "; ";
                switch (result[0].substring(0, bound)) {
                    case "500":
                    case "400":
                        writer.write(base);
                        break;
                    case "200":
                        writer.write("\n" + base);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
