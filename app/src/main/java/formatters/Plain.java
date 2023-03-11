package formatters;

import java.util.TreeMap;
import java.util.TreeSet;

public class Plain {

    public static String format(TreeMap<String, Object> value1, TreeMap<String, Object> value2) {
        StringBuilder result = new StringBuilder();

        TreeSet<String> setKeys = new TreeSet<>(value1.keySet());
        setKeys.addAll(value2.keySet());

        for (final String key: setKeys) {
            final String compareValue1 = String.valueOf(value1.get(key));
            final String compareValue2 = String.valueOf(value2.get(key));
            final String valOne = handlingValuesByType(value1.get(key));
            final String valTwo = handlingValuesByType(value2.get(key));

            if (value2.containsKey(key) && value1.containsKey(key)) {
                if (!compareValue1.equals(compareValue2)) {
                    result.append("Property '").append(key).append("' was updated. From ").append(valOne)
                            .append(" to ").append(valTwo).append("\n");
                }
            } else if (!value1.containsKey(key)) {
                result.append("Property '").append(key).append("' was added with value: ").append(valTwo).append("\n");
            } else if (!value2.containsKey(key)) {
                result.append("Property '").append(key).append("' was removed").append("\n");
            }
        }

        return result.substring(0, result.length() - 1);
    }

    private static String handlingValuesByType(Object object) {
        String result = String.valueOf(object);

        if (result.contains("[") || result.contains("{")) {
            return "[complex value]";
        } else if (object instanceof String) {
            return "'" + result + "'";
        }

        return result;

    }

}
