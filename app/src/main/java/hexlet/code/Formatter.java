package hexlet.code;

import formatters.Json;
import formatters.Plain;
import formatters.Stylish;

import java.util.TreeMap;

public class Formatter {

    public static String makeFormat(TreeMap<String, Object> value1, TreeMap<String, Object> value2, String format)
            throws Exception {
        final String result;

        if (format.equals("plain")) {
            result = Plain.format(value1, value2);
        } else if (format.equals("stylish")) {
            result = Stylish.format(value1, value2);
        } else if (format.equals("json")) {
            result = Json.format(value1, value2);
        } else {
            throw new Exception("There is unknown output format.\nCheck it!");
        }

        return result;
    }
}
