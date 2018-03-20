package chapter8.SOLID.D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FindHeading {
    private List<String> findHeadings(Reader input) {
        try (BufferedReader reader = new BufferedReader(input)) {
            return reader.lines()
                    .filter(line -> line.endsWith(":"))
                    .map(line -> line.substring(0, line.length() - 1))
                    .collect(toList());
        } catch (IOException e) {
            throw new HeadingLookupException(e);
        }
    }

    private List<String> findHeadings2(Reader input) {
        return withLinesOf(input,
                lines -> lines.filter(line -> line.endsWith(":"))
                        .map(line -> line.substring(0, line.length() - 1))
                        .collect(toList()),
                HeadingLookupException::new);
    }

    private <T> T withLinesOf(Reader input,
                              Function<Stream<String>, T> handler,
                              Function<IOException, RuntimeException> error) {
        try (BufferedReader reader = new BufferedReader(input)) {
            return handler.apply(reader.lines());
        } catch (IOException e) {
            throw error.apply(e);
        }
    }
}
