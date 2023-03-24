package formatters;

import java.util.TreeMap;
import java.util.TreeSet;

public class Plain {

    static StringBuilder result = new StringBuilder();
    static String compareValue1;
    static String compareValue2;
    static String valOne;
    static String valTwo;

    public static String format(TreeMap<String, Object> value1, TreeMap<String, Object> value2,
            TreeSet<String> setKeys) {

        result = new StringBuilder();

        for (final String key: setKeys) {
            compareValue1 = String.valueOf(value1.get(key));
            compareValue2 = String.valueOf(value2.get(key));
            valOne = handlingValuesByType(value1.get(key));
            valTwo = handlingValuesByType(value2.get(key));

            ifFilesHasKeys(value2.containsKey(key) && value1.containsKey(key), key);
            if (!value1.containsKey(key)) {
                result.append("Property '").append(key).append("' was added with value: ").append(valTwo).append("\n");
            } else if (!value2.containsKey(key)) {
                result.append("Property '").append(key).append("' was removed").append("\n");
            }
        }

        System.out.println(result.substring(0, result.length() - 1));
        return result.substring(0, result.length() - 1);
    }

    private static String handlingValuesByType(Object object) {
        String value = String.valueOf(object);

        if (value.contains("[") || value.contains("{")) {
            return "[complex value]";
        } else if (object instanceof String) {
            return "'" + value + "'";
        }

        return value;

    }

    private static void ifFilesHasKeys(boolean condition, String key) {

        if (condition) {
            if (!compareValue1.equals(compareValue2)) {
                result.append("Property '").append(key).append("' was updated. From ").append(valOne)
                        .append(" to ").append(valTwo).append("\n");
            }
        }

    }

}
