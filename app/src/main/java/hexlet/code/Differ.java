package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class Differ {

    public static String generate(File filepath1, File filepath2) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final TreeMap<String, String> value1 = mapper.readValue(filepath1, new TypeReference<TreeMap<String,String>>(){});
        final TreeMap<String, String> value2 = mapper.readValue(filepath2, new TypeReference<TreeMap<String,String>>(){});
        LinkedList<String> differernceList = new LinkedList<>();

        System.out.println("File content 1:\n" + value1);
        System.out.println("File content 2:\n" + value2 + "\n");

        TreeSet<String> setKeys = new TreeSet<>(value1.keySet());
        setKeys.addAll(value2.keySet());

        for (final String key: setKeys){
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


        final String result = myToString(differernceList);

        System.out.println("Differenses:");
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
