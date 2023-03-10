package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

public class Tests {

    @Test
    public void sourceTest() throws Exception {

        final File filepath1 = new File("./src/test/resources/testFile1.json");
        final File filepath2 = new File("./src/test/resources/testFile2.json");

        final String result = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";

        assertEquals(result, Differ.generate(filepath1, filepath2));
    }

    @Test
    public void oneEmptyFileTest() throws Exception {

        final File filepath1 = new File("./src/test/resources/testFile1.json");
        final File filepath2 = new File("./src/test/resources/emptyTestFile.json");

        final String result = """
                {
                  - follow: false
                  - host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                }""";

        assertEquals(result, Differ.generate(filepath1, filepath2));
    }
}
