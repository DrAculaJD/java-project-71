package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.*;

public class Differ {

    public static String generate(File filepath1, File filepath2) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final TreeMap<String, String> value1 = mapper.readValue(filepath1, new TypeReference<TreeMap<String,String>>(){});
        final TreeMap<String, String> value2 = mapper.readValue(filepath2, new TypeReference<TreeMap<String,String>>(){});
        List<String> differernceList = new LinkedList<>();

        Set<String> setKeys = new TreeSet<>(value1.keySet());
        setKeys.addAll(value2.keySet());

        for (String key: setKeys){
            if (value2.containsKey(key) && value1.containsKey(key)) {
                if (value2.get(key).equals(value1.get(key))) {
                    differernceList.add("  " + key + ": " + value1.get(key));
                } else  {
                    differernceList.add("- " + key + ": " + value1.get(key));
                    differernceList.add("+ " + key + ": " + value2.get(key));
                }
            } else if (!value1.containsKey(key)) {
                differernceList.add("+ " + key + ": " + value2.get(key));
            } else if (!value2.containsKey(key)) {
                differernceList.add("- " + key + ": " + value1.get(key));
            }
        }

        System.out.println("File content 1:\n" + value1);
        System.out.println("File content 2:\n" + value2 + "\n");

        final String result = "Differenses:\n" + myToString(differernceList);
        System.out.println(result);
        return result;
    }

    public static String myToString(List<String> differernceList) {
        String result = "{\n";

        for (String str: differernceList) {
            result += "  " + str + "\n";
        }

        result += "}";

        return result;
    }
}
