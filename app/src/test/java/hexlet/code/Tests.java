package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

public class Tests {

    private final String trueResult = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";

    @Test
    public void jsonFilesTest() throws Exception {

        final File filepath1 = new File("./src/test/resources/testFile1.json");
        final File filepath2 = new File("./src/test/resources/testFile2.json");

        assertEquals(trueResult, Differ.generate(filepath1, filepath2));
    }

    @Test
    public void ymlFilesTest() throws Exception {

        final File filepath1 = new File("./src/test/resources/testFile1.yml");
        final File filepath2 = new File("./src/test/resources/testFile2.yml");

        assertEquals(trueResult, Differ.generate(filepath1, filepath2));
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
