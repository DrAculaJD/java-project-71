package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.TreeMap;

public class Parser {

    public static final String[] FILE_EXTENSIONS = {"json", "yml", "yaml"};

    public static TreeMap<String, Object> parse(String fileAbsolutePath, String filepath) throws Exception {
        if (findFileExtension(filepath).equals("json")) {
            return parseJSON(fileAbsolutePath);
        } else if (findFileExtension(filepath).equals("yml") || findFileExtension(filepath).equals("yaml")) {
            return parseYML(fileAbsolutePath);
        } else {
            throw new Exception("Please, use formats: .json, .yml, .yaml");
        }
    }

    private static TreeMap<String, Object> parseJSON(String filepath) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final TreeMap<String, Object> value;
        value = mapper.readValue(filepath, new TypeReference<>() { });
        return value;
    }

    private static TreeMap<String, Object> parseYML(String filepath) throws Exception {
        final ObjectMapper mapper = new YAMLMapper();
        final TreeMap<String, Object> value;
        value = mapper.readValue(filepath, new TypeReference<>() { });
        return value;
    }

    private static String findFileExtension(String filePath) {
        String fileExtension = filePath.substring(filePath.lastIndexOf('.') + 1).toLowerCase();

        if (fileExtension.equals(FILE_EXTENSIONS[2])) {
            return FILE_EXTENSIONS[1];
        }
        return fileExtension;
    }
}
