package formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Json {

    static Map<String, Object> result = new LinkedHashMap<>();

    public static String format(TreeMap<String, Object> value1, TreeMap<String, Object> value2,
            TreeSet<String> setKeys) throws JsonProcessingException {

        final ObjectMapper mapper = new ObjectMapper();

        for (final String key: setKeys) {
            final String valOne = String.valueOf(value1.get(key));
            final String valTwo = String.valueOf(value2.get(key));

            if (value2.containsKey(key) && value1.containsKey(key)) {
                ifFilesHasKeys(valOne, valTwo, key);
            } else if (!value1.containsKey(key)) {
                result.put("+ " + key, valTwo);
            } else if (!value2.containsKey(key)) {
                result.put("- " + key, valOne);
            }
        }

        return mapper.writeValueAsString(result);
    }

    private static void ifFilesHasKeys(String valOne, String valTwo, String key) {

        if (valOne.equals(valTwo)) {
            result.put(key, valOne);
        } else {
            result.put("- " + key, valOne);
            result.put("+ " + key, valTwo);
        }

    }

}
