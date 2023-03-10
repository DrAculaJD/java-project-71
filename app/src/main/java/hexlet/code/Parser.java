package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.util.TreeMap;

public class Parser {

    public static TreeMap<String, String> parse(File filepath) throws Exception {
        if (getFileExtension(filepath).equals("json")) {
            return parseJSON(filepath);
        }

        return parseYML(filepath);
    }

    private static TreeMap<String, String> parseJSON(File filepath) throws Exception {
        final ObjectMapper mapper = new ObjectMapper();
        final TreeMap<String, String> value;
        value = mapper.readValue(filepath, new TypeReference<TreeMap<String, String>>() { });
        return value;
    }

    private static TreeMap<String, String> parseYML(File filepath) throws Exception {
        final ObjectMapper mapper = new YAMLMapper();
        final TreeMap<String, String> value;
        value = mapper.readValue(filepath, new TypeReference<TreeMap<String, String>>() { });
        return value;
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
