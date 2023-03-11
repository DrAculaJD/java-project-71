package hexlet.code;

import formatters.Json;
import formatters.Plain;
import formatters.Stylish;

import java.util.TreeMap;

public class Formatter {

    public static String makeFormat(TreeMap<String, Object> value1, TreeMap<String, Object> value2, String format)
            throws Exception {

        return switch (format) {
            case "plain" -> Plain.format(value1, value2);
            case "stylish" -> Stylish.format(value1, value2);
            case "json" -> Json.format(value1, value2);
            default -> throw new Exception("There is unknown output format.\nCheck it!");
        };
    }
}
