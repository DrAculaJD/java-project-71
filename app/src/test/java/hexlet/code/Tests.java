package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.TreeMap;

public class Tests {
    final ObjectMapper mapper = new ObjectMapper();

    TreeMap<String, String> value1 = new TreeMap<>();
    TreeMap<String, String> value2 = new TreeMap<>();

    @BeforeAll
    public void definitionOfVariables() throws Exception {
        final URL filepath1 = new URL("file:app/src/test/resources/testFile1.json");
        final URL filepath2 = new URL("file:app/src/test/resources/testFile2.json");
        value1 = mapper.readValue(filepath1, new TypeReference<TreeMap<String,String>>(){});
        value2 = mapper.readValue(filepath2, new TypeReference<TreeMap<String,String>>(){});
    }

    @Test
    public void sourceTest() {

    }
}
