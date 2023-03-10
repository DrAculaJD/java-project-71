package hexlet.code;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class Differ {

    public static String generate(File filepath1, File filepath2) throws Exception {
        final TreeMap<String, String> value1 = Parser.parse(filepath1);
        final TreeMap<String, String> value2 = Parser.parse(filepath2);
        LinkedList<String> differernceList = new LinkedList<>();

        System.out.println("File content 1:\n" + value1);
        System.out.println("File content 2:\n" + value2 + "\n");

        TreeSet<String> setKeys = new TreeSet<>(value1.keySet());
        setKeys.addAll(value2.keySet());

        for (final String key: setKeys) {
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

        System.out.println(result);
        return result;
    }

    public static String myToString(List<String> differernceList) {
        StringBuilder result = new StringBuilder("{\n");

        for (String str: differernceList) {
            result.append("  ").append(str).append("\n");
        }

        result.append("}");

        return result.toString();
    }
}
