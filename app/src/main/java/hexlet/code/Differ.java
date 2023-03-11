package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;


public class Differ {

    public static String generate(String filepath1, String filepath2) throws Exception {
        final String defaultFormat = "stylish";
        return generate(filepath1, filepath2, defaultFormat);
    }

    public static String generate(String filepath1, String filepath2, String format) throws Exception {

        final String firstFileAbsolutePath = checkIsFileExistThenToAbsolutePath(filepath1);
        final String secondFileAbsolutePath = checkIsFileExistThenToAbsolutePath(filepath2);

        final TreeMap<String, Object> value1 = Parser.parse(firstFileAbsolutePath, filepath1);
        final TreeMap<String, Object> value2 = Parser.parse(secondFileAbsolutePath, filepath2);

        final String result = Formatter.makeFormat(value1, value2, format);

        System.out.println(result);
        return result;
    }

    private static String checkIsFileExistThenToAbsolutePath(String filePath) throws IOException {
        Path absoluteFilePath = Paths.get(filePath).toAbsolutePath().normalize();

        if (!Files.exists(absoluteFilePath)) {
            throw new IOException("'" + absoluteFilePath + "' does not exist.\nCheck it!");
        }
        return Files.readString(absoluteFilePath);
    }
}
