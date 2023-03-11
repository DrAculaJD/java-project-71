package formatters;

import java.util.TreeMap;
import java.util.TreeSet;

public class Stylish {

    public static String format(TreeMap<String, Object> value1, TreeMap<String, Object> value2) {
        StringBuilder result = new StringBuilder("{\n");

        TreeSet<String> setKeys = new TreeSet<>(value1.keySet());
        setKeys.addAll(value2.keySet());

        for (final String key: setKeys) {
            final String valOne = String.valueOf(value1.get(key));
            final String valTwo = String.valueOf(value2.get(key));

            if (value2.containsKey(key) && value1.containsKey(key)) {
                if (valOne.equals(valTwo)) {
                    result.append("     ").append(key).append(": ").append(valOne).append("\n");
                } else {
                    result.append("   - ").append(key).append(": ").append(valOne).append("\n");
                    result.append("   + ").append(key).append(": ").append(valTwo).append("\n");
                }
            } else if (!value1.containsKey(key)) {
                result.append("   + ").append(key).append(": ").append(valTwo).append("\n");
            } else if (!value2.containsKey(key)) {
                result.append("   - ").append(key).append(": ").append(valOne).append("\n");
            }
        }

        result.append("}");

        return result.toString();
    }

}
