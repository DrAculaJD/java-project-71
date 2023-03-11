package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlainTests {

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
    public void jsonFilesPlainTest() throws Exception {

        final String filepath1 = "./src/test/resources/testFile1.json";
        final String filepath2 = "./src/test/resources/testFile2.json";

        assertEquals(truePlainResult, Differ.generate(filepath1, filepath2, "plain"));
    }

    @Test
    public void ymlFilesPlainTest() throws Exception {

        final String filepath1 = "./src/test/resources/testFile1.yml";
        final String filepath2 = "./src/test/resources/testFile2.yml";

        assertEquals(truePlainResult, Differ.generate(filepath1, filepath2, "plain"));
    }
}
