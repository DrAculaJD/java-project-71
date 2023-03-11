package hexlet.code;

import java.io.File;
import java.util.TreeMap;


public class Differ {

    public static String generate(File filepath1, File filepath2, String format) throws Exception {
        final TreeMap<String, Object> value1 = Parser.parse(filepath1);
        final TreeMap<String, Object> value2 = Parser.parse(filepath2);

        System.out.println("File content 1:\n" + value1);
        System.out.println("File content 2:\n" + value2 + "\n");

        final String result = Formatter.makeFormat(value1, value2, format);

        System.out.println(result);
        return result;
    }
}
