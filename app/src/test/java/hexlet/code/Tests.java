package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

public class Tests {

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

    private final String truePlainResult = """
            Property 'chars2' was updated. From [complex value] to false
            Property 'checked' was updated. From false to true
            Property 'default' was updated. From null to [complex value]
            Property 'id' was updated. From 45 to null
            Property 'key1' was removed
            Property 'key2' was added with value: 'value2'
            Property 'numbers2' was updated. From [complex value] to [complex value]
            Property 'numbers3' was removed
            Property 'numbers4' was added with value: [complex value]
            Property 'obj1' was added with value: [complex value]
            Property 'setting1' was updated. From 'Some value' to 'Another value'
            Property 'setting2' was updated. From 200 to 300
            Property 'setting3' was updated. From true to 'none'""";

    @Test
    public void jsonFilesStylishTest() throws Exception {

        final File filepath1 = new File("./src/test/resources/testFile1.json");
        final File filepath2 = new File("./src/test/resources/testFile2.json");

        assertEquals(trueStylishResult, Differ.generate(filepath1, filepath2, "stylish"));
    }

    @Test
    public void jsonFilesPlainTest() throws Exception {

        final File filepath1 = new File("./src/test/resources/testFile1.json");
        final File filepath2 = new File("./src/test/resources/testFile2.json");

        assertEquals(truePlainResult, Differ.generate(filepath1, filepath2, "plain"));
    }

//    @Test
//    public void jsonFormatTest() throws Exception {
//
//        final File filepath1 = new File("./src/test/resources/testFile1.json");
//        final File filepath2 = new File("./src/test/resources/testFile2.json");
//
//        assertEquals(truePlainResult, Differ.generate(filepath1, filepath2, "json"));
//    }

    @Test
    public void ymlFilesStylishTest() throws Exception {

        final File filepath1 = new File("./src/test/resources/testFile1.yml");
        final File filepath2 = new File("./src/test/resources/testFile2.yml");

        assertEquals(trueStylishResult, Differ.generate(filepath1, filepath2, "stylish"));
    }

    @Test
    public void oneEmptyFileStylishTest() throws Exception {

        final File filepath1 = new File("./src/test/resources/testFile1.json");
        final File filepath2 = new File("./src/test/resources/emptyTestFile.json");

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
