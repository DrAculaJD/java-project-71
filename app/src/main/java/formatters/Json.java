package formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Json {

    public static String format(TreeMap<String, Object> value1, TreeMap<String, Object> value2,
            TreeSet<String> setKeys) throws JsonProcessingException {

        final ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> result = new LinkedHashMap<>();

        for (final String key: setKeys) {
            final String valOne = String.valueOf(value1.get(key));
            final String valTwo = String.valueOf(value2.get(key));

            if (value2.containsKey(key) && value1.containsKey(key)) {
                if (valOne.equals(valTwo)) {
                    result.put(key, valOne);
                } else {
                    result.put("- " + key, valOne);
                    result.put("+ " + key, valTwo);
                }
            } else if (!value1.containsKey(key)) {
                result.put("+ " + key, valTwo);
            } else if (!value2.containsKey(key)) {
                result.put("- " + key, valOne);
            }
        }

        final String json = mapper.writeValueAsString(result);
        System.out.println(json);

        return json;
    }

}
