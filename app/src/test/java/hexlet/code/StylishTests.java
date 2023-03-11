package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StylishTests {

    private final String trueStylishResult = """
            {
                 chars1: [a, b, c]
               - chars2: [d, e, f]
               + chars2: false
               - checked: false
               + checked: true
               - default: null
               + default: [value1, value2]
               - id: 45
               + id: null
               - key1: value1
               + key2: value2
                 numbers1: [1, 2, 3, 4]
               - numbers2: [2, 3, 4, 5]
               + numbers2: [22, 33, 44, 55]
               - numbers3: [3, 4, 5]
               + numbers4: [4, 5, 6]
               + obj1: {nestedKey=value, isNested=true}
               - setting1: Some value
               + setting1: Another value
               - setting2: 200
               + setting2: 300
               - setting3: true
               + setting3: none
            }""";

    @Test
    public void jsonFilesStylishTest() throws Exception {

        final String filepath1 = "./src/test/resources/testFile1.json";
        final String filepath2 = "./src/test/resources/testFile2.json";

        assertEquals(trueStylishResult, Differ.generate(filepath1, filepath2, "stylish"));
    }

    @Test
    public void ymlFilesStylishTest() throws Exception {

        final String filepath1 = "./src/test/resources/testFile1.yml";
        final String filepath2 = "./src/test/resources/testFile2.yml";

        assertEquals(trueStylishResult, Differ.generate(filepath1, filepath2, "stylish"));
    }

    @Test
    public void oneEmptyFileStylishTest() throws Exception {

        final String filepath1 = "./src/test/resources/testFile1.json";
        final String filepath2 = "./src/test/resources/emptyTestFile.json";

        final String result = """
                {
                   - chars1: [a, b, c]
                   - chars2: [d, e, f]
                   - checked: false
                   - default: null
                   - id: 45
                   - key1: value1
                   - numbers1: [1, 2, 3, 4]
                   - numbers2: [2, 3, 4, 5]
                   - numbers3: [3, 4, 5]
                   - setting1: Some value
                   - setting2: 200
                   - setting3: true
                }""";

        assertEquals(result, Differ.generate(filepath1, filepath2, "stylish"));
    }
}
