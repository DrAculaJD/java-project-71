package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.util.TreeMap;

public class Parser {

    public static TreeMap<String, Object> parse(File filepath) throws Exception {
        if (getFileExtension(filepath).equals("json")) {
            return parseJSON(filepath);
        } else if (getFileExtension(filepath).equals("yml") || getFileExtension(filepath).equals("yaml")) {
            return parseYML(filepath);
        } else {
            throw new Exception("Please, use formats: .json, .yml, .yaml");
        }
    }

    private static TreeMap<String, Object> parseJSON(File filepath) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final TreeMap<String, Object> value;
        value = mapper.readValue(filepath, new TypeReference<>() { });
        return value;
    }

    private static TreeMap<String, Object> parseYML(File filepath) throws Exception {
        final ObjectMapper mapper = new YAMLMapper();
        final TreeMap<String, Object> value;
        value = mapper.readValue(filepath, new TypeReference<>() { });
        return value;
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        return "";
    }
}
