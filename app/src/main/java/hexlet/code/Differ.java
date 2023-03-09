package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;

public class Differ {

    public static String generate(File filepath1, File filepath2) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        final Map value1 = mapper.readValue(filepath1, Map.class);
        final Map value2 = mapper.readValue(filepath2, Map.class);

        System.out.println(value1);
        System.out.println(value2);
        String result = "empty string";
        return result;
    }
}
